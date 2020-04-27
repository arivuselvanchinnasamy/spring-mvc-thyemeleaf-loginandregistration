package com.arivu.login.service;

import java.math.BigInteger;
import java.util.List;

import com.arivu.login.model.Role;
import com.arivu.login.model.UserRole;


/**
 * @author Arivuselvan
 *
 */
public interface IUserRoleService extends IBaseService<UserRole> {

	List<Role> findRolesByUserId(BigInteger userId);

}
