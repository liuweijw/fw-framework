package com.github.liuweijw.api.security.auth.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liuweijw.api.core.http.AjaxResult;
import com.github.liuweijw.api.security.ErrorCode;
import com.github.liuweijw.api.security.exceptions.AuthMethodNotSupportedException;
import com.github.liuweijw.api.security.exceptions.JwtExpiredTokenException;

/**
 * 鉴权失败处理
 * 
 * @author liuweijw
 *
 */
@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private final ObjectMapper mapper;

	@Autowired
	public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {

		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		if (e instanceof BadCredentialsException) {
			mapper.writeValue(response.getWriter(), AjaxResult.of("Invalid username or password",ErrorCode.AUTHENTICATION.getErrorCode(),HttpStatus.UNAUTHORIZED.value()));
		} else if (e instanceof JwtExpiredTokenException) {
			mapper.writeValue(response.getWriter(), AjaxResult.of("Token has expired",ErrorCode.JWT_TOKEN_EXPIRED.getErrorCode(),HttpStatus.UNAUTHORIZED.value()));
		} else if (e instanceof AuthMethodNotSupportedException) {
			mapper.writeValue(response.getWriter(), AjaxResult.of(e.getMessage(), ErrorCode.AUTHENTICATION.getErrorCode(),HttpStatus.UNAUTHORIZED.value()));
		}

		mapper.writeValue(response.getWriter(), AjaxResult.of("Authentication failed",ErrorCode.AUTHENTICATION.getErrorCode(),HttpStatus.UNAUTHORIZED.value()));
	}
}
