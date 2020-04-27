package com.arivu.login.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.arivu.login.model.UserProfile;
import com.arivu.login.repository.IUserProfileRepository;
import com.arivu.login.service.IUserProfileService;

/**
 * @author Arivuselvan
 *
 */
@Service(UserProfileServiceImpl.BEAN_ID)
@Validated
public class UserProfileServiceImpl extends AbstractBaseServiceImpl<UserProfile, IUserProfileRepository>
	implements IUserProfileService {
	
	public static final String BEAN_ID = "uerProfileService";
		
	public UserProfileServiceImpl() {
		super();
	}

	@Override
	public UserProfile findByUserName(String userName) {
		return this.repository.findByUserName(userName);		
	}
	

}
