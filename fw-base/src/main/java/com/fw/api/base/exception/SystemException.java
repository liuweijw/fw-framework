package com.fw.api.base.exception;

/**
 * 系统业务异常.
 *
 * @author liuweijw
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -1312066729114650096L;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
}