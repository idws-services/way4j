package com.way4j.dao.transaction;

public interface ITransactionManager<T>{
	
	T startTransaction();
	void commitTransaction(T transaction);
	
}
