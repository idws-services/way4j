package com.way4j.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.way4j.appConfig.ApplicationConfigurator;

public class Way4jContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		
		ApplicationConfigurator.configureContext(sce.getServletContext());
		
		//Spring.getBean(SchedulerService.class).schedule(new MyJob(), "* * * * * ?");
		
		
	}

	public void contextDestroyed(ServletContextEvent sce) {}

}
