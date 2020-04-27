package com.arivu.login.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.arivu.login.model.AbstractDatabaseEntity;

@NoRepositoryBean
public interface IBaseRepository <T extends AbstractDatabaseEntity, ID extends Serializable>
			extends JpaRepository <T, ID> {

	
}
