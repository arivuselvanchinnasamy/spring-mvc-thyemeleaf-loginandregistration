package com.arivu.login.repository;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.arivu.login.model.Role;


@Repository
public interface IRoleRepository extends IBaseRepository<Role,BigInteger> {

	Role findByName(String roleName);
}
