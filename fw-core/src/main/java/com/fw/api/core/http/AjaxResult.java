package com.fw.api.core.http;

/**
 * Ajax 请求全局处理
 * 
 * @author LW
 *
 */
public class AjaxResult {
	
	private boolean result = false;
	
	private String message = "";
	
	private String result_type = "0";
	
	private String result_code = "0";
	
	private Object data;

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
	
}
