package com.github.liuweijw.api.security.exceptions;

/**
 * 
 * 服务异常
 * 
 * @author liuweijw
 *
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -3140138114629995495L;

	public ServiceException(String msg) {
		super(msg);
	}

}
