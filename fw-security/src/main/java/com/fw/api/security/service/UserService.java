package com.fw.api.security.service;

import java.util.Optional;

import com.fw.api.security.domain.IUser;

/**
 * 登录名获取用户信息
 * 
 * @author LW
 *
 */
public interface UserService {

	public Optional<IUser> getUserByUsername(String username);

}
