package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hello")
public class HelloDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloDemoApplication.class, args);
	}

}
