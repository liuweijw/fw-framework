package com.github.liuweijw.api.security.domain;

import java.util.List;

/**
 * 用户信息接口
 * 
 * @author liuweijw
 */
public interface IUser {

	public Long getId();

	public String getUsername();

	public String getPassword();

	public List<IUserRole> getUserRoles();

}
