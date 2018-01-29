package com.github.liuweijw.api.security.auth.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.github.liuweijw.api.security.UserContext;
import com.github.liuweijw.api.security.domain.IUser;
import com.github.liuweijw.api.security.service.UserService;

@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Assert.notNull(authentication, "No authentication data provided");

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		IUser user = userService.getUserByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found: " + username));

		if (!encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
		}

		if (user.getUserRoles() == null)
			throw new InsufficientAuthenticationException("User has no roles assigned");

		List<GrantedAuthority> authorities = user
				.getUserRoles()
				.stream()
				.map(authority -> new SimpleGrantedAuthority(authority
						.getRole().authority())).collect(Collectors.toList());

		UserContext userContext = UserContext.create(user.getUsername(), authorities);

		return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
