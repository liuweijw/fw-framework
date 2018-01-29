package com.github.liuweijw.api.security.domain;

/**
 * Enumerated {@link User} roles.
 * 
 * @author liuweijw
 */
public enum Role {

	ADMIN, MEMBER, AUTH;

	public String authority() {
		return "ROLE_" + this.name();
	}
}
