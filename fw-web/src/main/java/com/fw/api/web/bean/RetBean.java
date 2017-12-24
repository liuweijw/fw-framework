package com.fw.api.web.bean;

public class RetBean {

	private int key;
	
	private String msg;
	
	public RetBean(int key,String msg){
		this.key = key;
		this.msg = msg;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
