package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebAppTestApplication {
	
	//NOTE : ALL THE VIEW PAGES MUST BE IN A FOLDER "webapp" as this path is configured by default
	//	     In case we change the path we need to specify it in the application.properties file

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppTestApplication.class, args);
	}

}
