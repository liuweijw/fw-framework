package com.github.liuweijw.api.security.auth.ajax;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import com.github.liuweijw.api.security.UserContext;
import com.github.liuweijw.api.security.token.RawAccessJwtToken;

public class AjaxRefreshAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 2401455890865810008L;

	private RawAccessJwtToken rawAccessToken;
	private UserContext userContext;
	
	public AjaxRefreshAuthenticationToken(UserContext userContext) {
		super(userContext.getAuthorities());
		this.eraseCredentials();
		this.userContext = userContext;
		super.setAuthenticated(true);
	}
	
	public AjaxRefreshAuthenticationToken(RawAccessJwtToken rawAccessToken,
			UserContext userContext) {
		super(null);
		this.rawAccessToken = rawAccessToken;
		this.userContext = userContext;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return rawAccessToken;
	}

	@Override
	public Object getPrincipal() {
		return userContext;
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		this.rawAccessToken = null;
	}
}
