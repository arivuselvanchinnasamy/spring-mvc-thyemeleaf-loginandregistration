package com.arivu.login.service;

import com.arivu.login.model.Role;


/**
 * @author Arivuselvan
 *
 */
public interface IRoleService extends IBaseService<Role> {

	Role findByName(String roleName);

}
