package com.fw.api.security.auth.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fw.api.security.UserContext;
import com.fw.api.security.domain.IUser;
import com.fw.api.security.service.UserService;

@Component
public class AjaxRefreshAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Assert.notNull(authentication, "No authentication data provided");

		UserContext authUserContext = (UserContext) authentication.getPrincipal();
		String username = authUserContext.getUsername();
		IUser user = userService.getUserByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found: " + username));

		if (user.getUserRoles() == null)
			throw new InsufficientAuthenticationException("User has no roles assigned");

		List<GrantedAuthority> authorities = user
				.getUserRoles()
				.stream()
				.map(authority -> new SimpleGrantedAuthority(authority
						.getRole().authority())).collect(Collectors.toList());

		UserContext userContext = UserContext.create(user.getUsername(), authorities);
		
		return new AjaxRefreshAuthenticationToken(userContext);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (AjaxRefreshAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
