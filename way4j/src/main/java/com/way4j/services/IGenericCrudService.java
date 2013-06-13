package com.way4j.services;

import java.util.List;

public interface IGenericCrudService<T> extends IGenericService{
	
	void insert(T obj);
	void insert(List<T> obj);
	
	List<T> list(String filter);
	T get(String filter);
	
	void delete(String filter);
	
	void update(T obj, String filter);
	
}
