package com.arivu.login.service;

import com.arivu.login.model.User;


/**
 * @author Arivuselvan
 *
 */
public interface IUserService extends IBaseService<User> {

	User findByUserName(String userName);

}
