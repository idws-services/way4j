package com.way4j.appConfig.service;

import com.way4j.appConfig.interfaces.IClassFactory;
import com.way4j.appConfig.interfaces.ILevator;
import com.way4j.services.scheduling.SchedulerService;
import com.way4j.utils.Spring;

// Respon�vel por chamar o gerador de classes (Utilizando a ClassFactory), para cada modelo dispon�vel
// e registra-lo no contexto do spring.

public class ServiceLevator implements ILevator {
	
	private IClassFactory serviceClassFactory;
	
	public ServiceLevator(){
		serviceClassFactory = new ServiceClassFactory();
	}
	
	public void up(){
		registerWay4jServices();
		registerApplicationServices();
	}

	// Registra os servi�os do framework.
	private void registerWay4jServices(){
		// a busca deve ser dinmica no pacote com.way4j.service
		// por todas as classes que implementam GenericService, e que
		// interessa para a aplica��o.
		Spring.registerSingleton(SchedulerService.class);
	}
	
	// Registra os servi�os para os models da aplica��o.
	private void registerApplicationServices(){
		// serviceClassFactory.build(model);
	}
	
}
