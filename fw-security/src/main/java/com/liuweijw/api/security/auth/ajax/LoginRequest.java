package com.liuweijw.api.security.auth.ajax;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model intended to be used for AJAX based authentication.
 * 
 * @author liuweijw
 */

public class LoginRequest {

	private String username;

	private String password;

	@JsonCreator
	public LoginRequest(@JsonProperty("username") String username,
			@JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
