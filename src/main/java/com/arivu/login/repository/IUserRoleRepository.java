package com.arivu.login.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arivu.login.model.Role;
import com.arivu.login.model.UserRole;


@Repository
public interface IUserRoleRepository extends IBaseRepository<UserRole, BigInteger> {

	@Query("SELECT r from UserRole ur, Role r WHERE (ur.id) = :userId AND ur.role.id = r.id ")
	List<Role> findRolesByUserId(@Param("userId")BigInteger userId);

}
