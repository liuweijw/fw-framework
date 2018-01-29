package com.github.liuweijw.api.security.token;

import io.jsonwebtoken.Claims;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Raw representation of JWT Token.
 * 
 * @author liuweijw
 */
public final class AccessJwtToken implements JwtToken {

	private final String rawToken;

	@JsonIgnore
	private Claims claims;

	protected AccessJwtToken(final String token, Claims claims) {
		this.rawToken = token;
		this.claims = claims;
	}

	@Override
	public String getToken() {
		return this.rawToken;
	}

	public Claims getClaims() {
		return claims;
	}
}
