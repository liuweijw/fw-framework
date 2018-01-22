package com.fw.api.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fw.api.security.auth.ajax.AjaxAuthenticationProvider;
import com.fw.api.security.auth.ajax.AjaxLoginProcessingFilter;
import com.fw.api.security.auth.ajax.AjaxRefreshAuthenticationProvider;
import com.fw.api.security.auth.ajax.AjaxRefreshTokenAuthenticationFilter;
import com.fw.api.security.auth.jwt.JwtAuthenticationProvider;
import com.fw.api.security.auth.jwt.JwtTokenAuthenticationProcessingFilter;
import com.fw.api.security.auth.jwt.SkipPathRequestMatcher;
import com.fw.api.security.auth.jwt.extractor.TokenExtractor;

/**
 * WebSecurityConfig
 * 
 * @author liuweijw
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启 ("hasRole('AUTH')")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
	public static final String AUTHENTICATION_URL = "/api/auth/login";
	public static final String REFRESH_TOKEN_URL = "/api/auth/token";
	public static final String LOGOUT_TOKEN_URL = "/api/auth/logout";
	public static final String API_ROOT_URL = "/api/**";

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	@Autowired
	private AuthenticationFailureHandler failureHandler;
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	@Autowired
	private AjaxAuthenticationProvider ajaxAuthenticationProvider;
	@Autowired
	private AjaxRefreshAuthenticationProvider ajaxRefreshAuthenticationProvider;
	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;
	@Autowired
	private TokenExtractor tokenExtractor;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private JwtSettings jwtSettings;

	protected AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter(
			String loginEntryPoint) throws Exception {
		AjaxLoginProcessingFilter filter = new AjaxLoginProcessingFilter(
				loginEntryPoint, successHandler, failureHandler, objectMapper);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	protected AjaxRefreshTokenAuthenticationFilter buildAjaxRefeshTokenAuthenticationFilter(
			String refeshEntryPoint) throws Exception {
		AjaxRefreshTokenAuthenticationFilter filter = new AjaxRefreshTokenAuthenticationFilter(
				refeshEntryPoint,successHandler,failureHandler, tokenExtractor,jwtSettings);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}
	
	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(
			List<String> pathsToSkip, String pattern) throws Exception {
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(
				pathsToSkip, pattern);
		JwtTokenAuthenticationProcessingFilter filter = new JwtTokenAuthenticationProcessingFilter(
				failureHandler, tokenExtractor, matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(ajaxAuthenticationProvider);
		auth.authenticationProvider(ajaxRefreshAuthenticationProvider);
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		List<String> permitAllEndpointList = Arrays.asList(
				AUTHENTICATION_URL,
				REFRESH_TOKEN_URL,
				LOGOUT_TOKEN_URL
		);

		http.csrf()
				.disable()
				// We don't need CSRF for JWT based authentication
				.exceptionHandling()
				.authenticationEntryPoint(this.authenticationEntryPoint)

				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				.and()
				.authorizeRequests()
				.antMatchers(permitAllEndpointList.toArray(new String[permitAllEndpointList.size()]))
				.permitAll()
				
				.and()
				.logout()
				.logoutUrl(LOGOUT_TOKEN_URL)
				.logoutSuccessHandler(logoutSuccessHandler)
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				
				.and()
				.authorizeRequests()
				.antMatchers(API_ROOT_URL)
				.authenticated()
				
				// Protected API End-points
				.and()
				.addFilterBefore(new SecurityCorsFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildAjaxLoginProcessingFilter(AUTHENTICATION_URL), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildAjaxRefeshTokenAuthenticationFilter(REFRESH_TOKEN_URL), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(permitAllEndpointList, API_ROOT_URL), UsernamePasswordAuthenticationFilter.class);
	}
}
