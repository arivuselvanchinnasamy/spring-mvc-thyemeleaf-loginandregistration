package com.arivu.login.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arivu.login.model.AbstractDatabaseEntity;
import com.arivu.login.repository.IBaseRepository;
import com.arivu.login.service.IBaseService;

/**
 * @author Arivuselvan
 *
 * @param <T>
 * @param <R>
 */
@Transactional
public abstract class AbstractBaseServiceImpl<T extends AbstractDatabaseEntity, R extends IBaseRepository<T, BigInteger>>
		implements IBaseService<T> {

	@Autowired
	protected R repository;

	protected Class<T> entityType;

	protected Logger logger;
	
	@SuppressWarnings("unchecked")
	public AbstractBaseServiceImpl() {
		Class<?>[] classArray = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractBaseServiceImpl.class);
		this.entityType = (Class<T>) classArray[0];
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@Override
	public List<T> findAll() {
		return this.repository.findAll();
	}
	
	@Override
	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public T create(T entity) {
		return save(entity);
	}

	@Override
	public T update(T entity) {
		return save(entity);
	}

	private T save(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public T findOne(BigInteger id) {
		return this.repository.getOne(id);
	}

	@Override
	public boolean exists(BigInteger id) {
		return this.repository.existsById(id);
	}

	@Override
	public void delete(BigInteger id) {
		this.repository.deleteById(id);			
	}

	
}
