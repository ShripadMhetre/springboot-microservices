package com.example.eurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer		// Enables eureka server
public class EurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegistryApplication.class, args);
	}

}
