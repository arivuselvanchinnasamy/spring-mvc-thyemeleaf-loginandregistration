package com.arivu.login.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.arivu.login.model.Role;
import com.arivu.login.model.UserRole;
import com.arivu.login.repository.IUserRoleRepository;
import com.arivu.login.service.IUserRoleService;

/**
 * @author Arivuselvan
 *
 */
@Service(UserRoleServiceImpl.BEAN_ID)
@Validated
public class UserRoleServiceImpl extends AbstractBaseServiceImpl<UserRole, IUserRoleRepository>
	implements IUserRoleService {
	
	public static final String BEAN_ID = "userRoleService";
		
	public UserRoleServiceImpl() {
		super();
	}

	@Override
	public List<Role> findRolesByUserId(BigInteger userId) {
		return this.repository.findRolesByUserId(userId);		
	}
	

}
