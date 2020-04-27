package com.arivu.login.service;

import com.arivu.login.model.UserProfile;


/**
 * @author Arivuselvan
 *
 */
public interface IUserProfileService extends IBaseService<UserProfile> {

	UserProfile findByUserName(String userName);

}
