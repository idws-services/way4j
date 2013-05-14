package com.way4j.dao;

import java.util.Map;

public interface IFilterCriteria<K, T> {
	
	T getCriteria();
	Map<K, T> getJoins();
	int getMax();
	int getMin();
	
}
