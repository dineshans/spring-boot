package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.eureka")
public class EurekaclientserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaclientserviceApplication.class, args);
	}

}
