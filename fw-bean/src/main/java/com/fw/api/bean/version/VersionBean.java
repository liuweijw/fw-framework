package com.fw.api.bean.version;

public class VersionBean {

	private Integer min_version;

	private Integer new_version;

	private String description;

	private String download_url;

	private Integer status;

	private Integer type = 1;

	private Integer responseId = 0;

	private Integer retcode = 0;

	private Integer rettype = 0;

	private String retmsg;

	public Integer getMin_version() {
		return min_version;
	}

	public void setMin_version(Integer min_version) {
		this.min_version = min_version;
	}

	public Integer getNew_version() {
		return new_version;
	}

	public void setNew_version(Integer new_version) {
		this.new_version = new_version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public Integer getRetcode() {
		return retcode;
	}

	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}

	public Integer getRettype() {
		return rettype;
	}

	public void setRettype(Integer rettype) {
		this.rettype = rettype;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

}
