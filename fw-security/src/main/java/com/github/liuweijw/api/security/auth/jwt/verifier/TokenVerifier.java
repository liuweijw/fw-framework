package com.github.liuweijw.api.security.auth.jwt.verifier;

/**
 * @author liuweijw
 */
public interface TokenVerifier {

	public boolean verify(String jti);

}
