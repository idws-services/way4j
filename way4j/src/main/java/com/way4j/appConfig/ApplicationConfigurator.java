package com.way4j.appConfig;

import javax.servlet.ServletContext;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.way4j.appConfig.dao.DaoLevator;
import com.way4j.appConfig.service.ServiceLevator;
import com.way4j.utils.GenericUtils;
import com.way4j.utils.Spring;

public class ApplicationConfigurator {
	
	public static void configureContext(ServletContext sc){
		configureSpringContext(sc);
		
		new ServiceLevator().up();
		new DaoLevator().up();
		
	}
	
	private static void configureSpringContext(ServletContext sc){
		GenericApplicationContext springGenericApplicationContext = new GenericApplicationContext(getSpringWebAppContext(sc));
		Spring.setContext(springGenericApplicationContext);
	}
	
	private static WebApplicationContext getSpringWebAppContext(ServletContext sc){
		return WebApplicationContextUtils.getWebApplicationContext(sc);
	}
	
	
}
