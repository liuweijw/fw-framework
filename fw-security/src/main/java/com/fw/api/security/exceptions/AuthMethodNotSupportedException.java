package com.fw.api.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

public class AuthMethodNotSupportedException extends AuthenticationServiceException {

	private static final long serialVersionUID = -9062895332818084502L;

	public AuthMethodNotSupportedException(String msg) {
		super(msg);
	}
}
