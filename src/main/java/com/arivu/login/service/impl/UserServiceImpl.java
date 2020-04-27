package com.arivu.login.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.arivu.login.model.User;
import com.arivu.login.repository.IUserRepository;
import com.arivu.login.service.IUserService;

@Service(UserServiceImpl.BEAN_ID)
@Validated
public class UserServiceImpl extends AbstractBaseServiceImpl<User, IUserRepository>
		implements IUserService {

	public static final String BEAN_ID = "userService";

	public UserServiceImpl() {
		super();
	}

	@Override
	public User findByUserName(String userName) {
		return this.repository.findByUserName(userName);
	}
	
}
