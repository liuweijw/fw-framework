package com.fw.api.web.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Version.TABLE_NAME)
public class Version implements Serializable {

	private static final long serialVersionUID = 8080157712721873L;

	public static final String TABLE_NAME = "t_fw_version";

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Long sid;

	/**
	 * 类型 1: android 0:ios
	 */
	@Column(name = "type")
	private Integer type = 1;

	/**
	 * 最低版本号
	 */
	@Column(name = "min_version")
	private Integer min_version;

	/**
	 * 最新版本号
	 */
	@Column(name = "new_version")
	private Integer new_version;

	/**
	 * 本次升级描述
	 */
	@Column(name = "description")
	private String description;

	/**
	 * 下载地址
	 */
	@Column(name = "download_url")
	private String download_url;

	/**
	 * 状态
	 */
	@Column(name = "status")
	private Integer status;

	/**
	 * 创建人
	 */
	@Column(name = "cuser")
	private String cuser;

	/**
	 * 创建时间
	 */
	@Column(name = "ctime")
	private Date ctime;

	/**
	 * 备注
	 */
	@Column(name = "memo")
	private String memo;

	/**
	 * 关于信息
	 */
	@Column(name = "aboutinfo")
	private String aboutinfo;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAboutinfo() {
		return aboutinfo;
	}

	public void setAboutinfo(String aboutinfo) {
		this.aboutinfo = aboutinfo;
	}

}
