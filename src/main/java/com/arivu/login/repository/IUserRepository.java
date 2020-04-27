package com.arivu.login.repository;

import java.math.BigInteger;

import com.arivu.login.model.User;

public interface IUserRepository extends IBaseRepository<User, BigInteger> {

	User findByUserName(String userName);
}
