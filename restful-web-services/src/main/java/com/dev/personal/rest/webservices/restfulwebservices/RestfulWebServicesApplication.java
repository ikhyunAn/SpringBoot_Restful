package com.dev.personal.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {
	/*
	Check: http://localhost:8080/swagger-ui/index.html
	for swagger openapi
	Check: http://localhost:8080/v3/api-docs
	for vs openapi
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
