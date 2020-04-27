package com.arivu.login.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arivu.login.model.UserProfile;

public interface IUserProfileRepository extends IBaseRepository<UserProfile, BigInteger> {

	@Query("SELECT up from UserProfile up, User u WHERE (u.userName) = :userName AND up.user.id = u.id ")
	UserProfile findByUserName(@Param("userName")String userName);
}
