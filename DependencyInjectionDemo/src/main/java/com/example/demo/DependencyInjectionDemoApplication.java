package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionDemoApplication.class, args);
		//SPRING_APPLICATION_RUN initializes the "SPRING CONTAINER"
		
		
		

		//Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.demo.Alien' available
		//We get this error if we don't specify in the Class that an Object or "SPRING BEAN" has to be created
		//in the Container 
		
		//And this is dependency Injection
		Alien a = context.getBean(Alien.class);
		
		a.show();
		
		
		//SCOPE IN A COMPONENT:
		//1. SINGLETON : this is the default scope that is only created once when the Spring Container is initialized
		//	 It is not dependent on whether the call for a object is made or not and It will create only object no
		//	 matter how many new calls are made
		//2. PROTOTYPE : this is set if dont want the spring container to create an object by default on initialization
		//	 and we want the spring container to create multiple copies of the object on each initialization
		
		
	}

}
