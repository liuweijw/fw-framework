package com.liuweijw.api.security.auth.ajax;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.liuweijw.api.security.JwtSettings;
import com.liuweijw.api.security.UserContext;
import com.liuweijw.api.security.WebSecurityConfig;
import com.liuweijw.api.security.auth.jwt.extractor.TokenExtractor;
import com.liuweijw.api.security.token.RawAccessJwtToken;
import com.liuweijw.api.security.token.RefreshToken;

public class AjaxRefreshTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private final JwtSettings jwtSettings;
	
	private final TokenExtractor tokenExtractor;
	
	private final AuthenticationSuccessHandler successHandler;
	
	private final AuthenticationFailureHandler failureHandler;
	
	public AjaxRefreshTokenAuthenticationFilter(String refeshEntryPoint,
			AuthenticationSuccessHandler successHandler,
			AuthenticationFailureHandler failureHandler,
			TokenExtractor tokenExtractor,
			JwtSettings jwtSettings) {
		super(refeshEntryPoint);
		this.tokenExtractor = tokenExtractor;
		this.successHandler = successHandler;
		this.failureHandler =failureHandler;
		this.jwtSettings = jwtSettings;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		String tokenPayload = request.getHeader(WebSecurityConfig.AUTHENTICATION_HEADER_NAME);
		RawAccessJwtToken accessRefreshToken = new RawAccessJwtToken(tokenExtractor.extract(tokenPayload));
		
		Optional<RefreshToken> refreshTokenOptaional = RefreshToken.create(accessRefreshToken, jwtSettings.getTokenSigningKey());
		if(!refreshTokenOptaional.isPresent()) throw new AuthenticationServiceException("Invalid Token");
		RefreshToken refreshToken = refreshTokenOptaional.get();
		UserContext userContext = UserContext.create(refreshToken.getSubject(), null);
		
		return this.getAuthenticationManager().authenticate(new AjaxRefreshAuthenticationToken(accessRefreshToken,userContext));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		successHandler.onAuthenticationSuccess(request, response, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}

}
