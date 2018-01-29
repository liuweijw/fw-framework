package com.liuweijw.api.web.service;

import java.util.Optional;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuweijw.api.security.domain.IUser;
import com.liuweijw.api.security.service.UserService;
import com.liuweijw.api.web.domain.User;
import com.liuweijw.api.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<IUser> getUserByUsername(String username) {
		if (StringHelper.isEmpty(username)) {
			return Optional.empty();
		}
		Optional<User> user = userRepository.findByUsername(username.trim());
		Optional<IUser> iUser = Optional.of(user.get());
		return iUser;
	}

}
