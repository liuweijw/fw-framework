package com.fw.api.base.exception;

/**
 * 业务异常.
 *
 * @author liuweijw
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 6194417822203662894L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

}