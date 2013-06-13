package com.way4j.utils;

import org.springframework.context.support.GenericApplicationContext;

import com.way4j.services.IGenericService;

public class Spring {
	
	public static GenericApplicationContext context;
	
	public static void setContext(GenericApplicationContext springGenericAppContext) {
		if(context == null){
			Spring.context = springGenericAppContext;	
		}
	}
	
	public IGenericService getService(Class model){
		return null;
	}
	
	public IGenericService getDao(Class model){
		return null;
	}
	
	public static <T> T getBean(Class<T> clazz){
		return (T) context.getBean(clazz.getSimpleName());
	}
	
	public static void registerSingleton(Class clazz){
		try {
			Spring.context.getBeanFactory().registerSingleton(clazz.getSimpleName(), clazz.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}	
}
