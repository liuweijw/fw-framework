package com.fw.api.core.http;

import java.util.Date;

/**
 * Ajax 请求全局处理
 * 
 * @author liuweijw
 *
 */
public class AjaxResult {

	private boolean result = false;

	private int status = 200;

	private String message = "";

	private String result_type = "0";

	private String result_code = "0";

	private long timestamp = new Date().getTime();

	private Object data;

	public static AjaxResult of(final String message, final int errorCode,
			final int status) {
		return new AjaxResult().status(status)
				.resultCode(String.valueOf(errorCode)).failure(message);
	}

	public AjaxResult success() {
		this.result = true;
		return this;
	}

	public AjaxResult success(String message) {
		this.result = true;
		this.message = message;
		return this;
	}

	public AjaxResult failure() {
		this.result = false;
		return this;
	}

	public AjaxResult status(int status) {
		this.result = (status == 200);
		this.status = status;
		return this;
	}

	public AjaxResult resultType(String result_type) {
		this.result_type = result_type;
		return this;
	}

	public AjaxResult resultCode(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public AjaxResult failure(String message) {
		this.result = false;
		this.message = message;
		return this;
	}

	public AjaxResult data(Object data) {
		this.data = data;
		return this;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult_type() {
		return result_type;
	}

	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
