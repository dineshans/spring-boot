package com.deployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootKubernetesDeploymentExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKubernetesDeploymentExampleApplication.class, args);
	}

	@GetMapping("/hello")
	public String getMessage(){

		return "Hello, I am new in Kubernetes";

	}

}
