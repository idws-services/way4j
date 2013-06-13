package com.way4j.dao;

import java.util.List;

public interface IGenericDao<T> {
	
	void insert(T obj);
	void insert(List<T> obj);
	
	List<T> list(String filter);
	T get(String filter);
	
	void delete(String filter);
	void update(T obj, String filter);
	
}
