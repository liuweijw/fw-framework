package com.github.liuweijw.api.security.exceptions;

import org.springframework.security.core.AuthenticationException;

import com.github.liuweijw.api.security.token.JwtToken;

/**
 * 权限失效处理
 * 
 * @author liuweijw
 *
 */
public class JwtExpiredTokenException extends AuthenticationException {

	private static final long serialVersionUID = -2046633125259293619L;

	private JwtToken token;

	public JwtExpiredTokenException(String msg) {
		super(msg);
	}

	public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
		super(msg, t);
		this.token = token;
	}

	public String token() {
		return this.token.getToken();
	}
}
