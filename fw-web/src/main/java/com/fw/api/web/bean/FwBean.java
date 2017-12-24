package com.fw.api.web.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FwBean {

	@Value("${server.context-path}")
	private String contextPath;
	
	@Value("${fw.server.request.api.baseurl}")
	private String url;
	
	@Value("${fw.server.request.api.img}")
	private String imgContextPath;
	
	@Value("${fw.server.request.api.opentoken}")
	private boolean openToken;
	
	@Value("${fw.server.request.api.ex.show}")
	private boolean exShow;
	
	@Value("${fw.server.request.api.token.times}")
	private int tokenTimes;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getImgContextPath() {
		return imgContextPath;
	}

	public void setImgContextPath(String imgContextPath) {
		this.imgContextPath = imgContextPath;
	}
	
	public String getBaseReqUrl(){
		return this.url + this.contextPath;
	}

	public boolean isOpenToken() {
		return openToken;
	}

	public void setOpenToken(boolean openToken) {
		this.openToken = openToken;
	}

	public boolean isExShow() {
		return exShow;
	}

	public void setExShow(boolean exShow) {
		this.exShow = exShow;
	}

	public int getTokenTimes() {
		return tokenTimes;
	}

	public void setTokenTimes(int tokenTimes) {
		this.tokenTimes = tokenTimes;
	}
}
