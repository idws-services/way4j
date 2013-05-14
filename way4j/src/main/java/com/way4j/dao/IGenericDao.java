package com.way4j.dao;

import java.io.Serializable;
import java.util.List;

import com.way4j.dao.transaction.ITransactionManager;

public interface IGenericDao<K extends Serializable, T> {
	
	T get(K key);
	T get(IFilterCriteria criteria);
	
	List<T> list(IFilterCriteria criteria);
	
	void update(T obj);
	void update(T obj, IFilterCriteria criteria);
	
	void insert(T obj);
	
	void delete(K key);
	void delete(IFilterCriteria criteria);
	
	ITransactionManager getTransactionManager();
	
}
