package com.arivu.login.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.arivu.login.model.Role;
import com.arivu.login.repository.IRoleRepository;
import com.arivu.login.service.IRoleService;

@Service(RoleServiceImpl.BEAN_ID)
@Validated
public class RoleServiceImpl extends AbstractBaseServiceImpl<Role, IRoleRepository>
		implements IRoleService {

	public static final String BEAN_ID = "roleService";

	public RoleServiceImpl() {
		super();
	}

	@Override
	public Role findByName(String roleName) {
		return this.repository.findByName(roleName);
	}
	
}
