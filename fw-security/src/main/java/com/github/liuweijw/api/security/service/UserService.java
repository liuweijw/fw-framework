package com.github.liuweijw.api.security.service;

import java.util.Optional;

import com.github.liuweijw.api.security.domain.IUser;

/**
 * 登录名获取用户信息
 * 
 * @author LW
 *
 */
public interface UserService {

	public Optional<IUser> getUserByUsername(String username);

}
