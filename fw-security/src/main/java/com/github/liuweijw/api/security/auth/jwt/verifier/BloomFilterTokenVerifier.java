package com.github.liuweijw.api.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * BloomFilterTokenVerifier
 * 
 * @author liuweijw
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {

	@Override
	public boolean verify(String jti) {
		return true;
	}
}
