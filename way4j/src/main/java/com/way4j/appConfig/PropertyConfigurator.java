package com.way4j.appConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.quartz.impl.StdSchedulerFactory;

public class PropertyConfigurator {
	
	private static Class[] autoConfigurePropsClasses = {
											StdSchedulerFactory.class
										 };
	
	private static Map<Class, Properties> propsByClass;
	
	static{
		init();
	}
	
	private static void init(){
		propsByClass = new HashMap<Class, Properties>();
		for(Class c : autoConfigurePropsClasses){
			propsByClass.put(c, invokeGetPropertiesByClass(c));
		}
	}
	
	private static Properties invokeGetPropertiesByClass(Class clazz){
		try {
			Method getProps = PropertyConfigurator.class.getDeclaredMethod(getMethodGetPropsName(clazz));
			return (Properties) getProps.invoke(null);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return new Properties();
	}
	
	private static String getMethodGetPropsName(Class clazz){
		return "get"+clazz.getSimpleName()+"Props";
	}
	
	public static Properties getProperties(Class clazz){
		return propsByClass.get(clazz);
	}
	
	public static void refreshProperties(Class clazz){
		if(propsByClass.containsKey(clazz)){
			propsByClass.put(clazz, invokeGetPropertiesByClass(clazz));
		}
	}
	
	private static Properties getStdSchedulerFactoryProps(){
		if(propsByClass.get(StdSchedulerFactory.class) == null){
			Properties config = new Properties();
			
			config.setProperty("org.quartz.scheduler.instanceName", "Way4jDefaultSchedulerFactory");
			config.setProperty("org.quartz.scheduler.instanceId", "W4JDSF");
			config.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			config.setProperty("org.quartz.threadPool.threadCount", "10");
			config.setProperty("org.quartz.threadPool.threadPriority", "1");
			
			// consulta configurações, do applicationConfig.xml.
			
			propsByClass.put(StdSchedulerFactory.class, config);
		}
		return propsByClass.get(StdSchedulerFactory.class);
	}
	
}
