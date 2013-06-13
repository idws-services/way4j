package com.way4j.appConfig.service;

import com.way4j.appConfig.interfaces.IClassFactory;
import com.way4j.appConfig.interfaces.ILevator;
import com.way4j.services.scheduling.SchedulerService;
import com.way4j.utils.Spring;

// Responável por chamar o gerador de classes (Utilizando a ClassFactory), para cada modelo disponível
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

	// Registra os serviços do framework.
	private void registerWay4jServices(){
		// a busca deve ser dinmica no pacote com.way4j.service
		// por todas as classes que implementam GenericService, e que
		// interessa para a aplicação.
		Spring.registerSingleton(SchedulerService.class);
	}
	
	// Registra os serviços para os models da aplicação.
	private void registerApplicationServices(){
		// serviceClassFactory.build(model);
	}
	
}
