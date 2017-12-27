package com.fw.api.security;

public enum Scopes {

	REFRESH_TOKEN;

	public String authority() {
		return "ROLE_" + this.name();
	}

}
