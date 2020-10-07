package com.igp.mockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ConfigurationPropertiesScan
public class MockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockServiceApplication.class, args);
	}

}
