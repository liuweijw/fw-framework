package com.fw.api.security.exceptions;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fw.api.core.http.AjaxResult;

/**
 * 全局异常处理
 * 
 * @author liuweijw
 *
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

	private static Logger logger = LoggerFactory
			.getLogger(ExceptionAdvice.class);

	/**
	 * 400 - Bad Request
	 * 
	 * @throws IOException
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public AjaxResult handleMissingServletRequestParameterException(
			HttpServletRequest request, HttpServletResponse response,
			MissingServletRequestParameterException e) {
		logger.error("缺少请求参数" + request.getRequestURI(), e.getMessage());
		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, "请求参数不正确！", e.getMessage());
		return ajaxResult;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public AjaxResult handleHttpMessageNotReadableException(
			HttpServletRequest request, HttpServletResponse response,
			HttpMessageNotReadableException e) {
		logger.error("参数解析失败" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, "服务请求参数解析失败！", e.getMessage());
		return ajaxResult;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public AjaxResult handleMethodArgumentNotValidException(
			HttpServletRequest request, HttpServletResponse response,
			MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		String field = error.getField();
		String code = error.getDefaultMessage();
		String message = String.format("%s:%s:%s", field, code,
				error.getRejectedValue());
		logger.error("参数验证失败" + request.getRequestURI(), message);

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, code, e.getMessage());
		return ajaxResult;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public AjaxResult handleBindException(HttpServletRequest request,
			HttpServletResponse response, BindException e) {
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		String field = error.getField();
		String code = error.getDefaultMessage();
		String message = String.format("%s:%s", field, code);
		logger.error("参数绑定失败" + request.getRequestURI(), message);

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, code, e.getMessage());
		return ajaxResult;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public AjaxResult handleServiceException(HttpServletRequest request,
			HttpServletResponse response, ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		ConstraintViolation<?> violation = violations.iterator().next();
		String message = violation.getMessage();
		logger.error("参数验证失败" + request.getRequestURI(), "parameter:" + message);

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, message, e.getMessage());
		return ajaxResult;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public AjaxResult handleValidationException(HttpServletRequest request,
			HttpServletResponse response, ValidationException e) {
		logger.error("参数验证失败" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.BAD_REQUEST, "服务参数校验失败！", e.getMessage());
		return ajaxResult;
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public AjaxResult handleHttpRequestMethodNotSupportedException(
			HttpServletRequest request, HttpServletResponse response,
			HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.METHOD_NOT_ALLOWED, "服务不支持当前请求！", e.getMessage());
		return ajaxResult;
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public AjaxResult handleHttpMediaTypeNotSupportedException(
			HttpServletRequest request, HttpServletResponse response,
			Exception e) {
		logger.error("不支持当前媒体类型" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.UNSUPPORTED_MEDIA_TYPE, "服务不支持当前媒体类型！",
				e.getMessage());
		return ajaxResult;
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ServiceException.class)
	public AjaxResult handleServiceException(HttpServletRequest request,
			HttpServletResponse response, ServiceException e) {
		logger.error("业务逻辑异常" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.INTERNAL_SERVER_ERROR, "请求服务失败，请稍后再试！",
				e.getMessage());
		return ajaxResult;
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public AjaxResult handleException(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		logger.error("通用异常" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.INTERNAL_SERVER_ERROR, "服务开小差了，请稍后再试！",
				e.getMessage());
		return ajaxResult;
	}

	/**
	 * 500 - 操作数据库出现异常:名称重复，外键关联
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public AjaxResult handleException(HttpServletRequest request,
			HttpServletResponse response, DataIntegrityViolationException e) {
		logger.error("操作数据库出现异常:" + request.getRequestURI(), e.getMessage());

		AjaxResult ajaxResult = buildRedirectUrl(request, response,
				HttpStatus.INTERNAL_SERVER_ERROR, "操作数据库出现异常：字段重复、有外键关联等!",
				e.getMessage());
		return ajaxResult;
	}

	private AjaxResult buildRedirectUrl(HttpServletRequest request,
			HttpServletResponse response, HttpStatus status, String message,
			String e) {

		AjaxResult ajaxResult = new AjaxResult().status(status.value())
				.resultCode(String.valueOf(status)).failure(message).data(e);

		return ajaxResult;
	}
}
