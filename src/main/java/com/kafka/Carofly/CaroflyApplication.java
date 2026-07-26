package com.kafka.Carofly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CaroflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaroflyApplication.class, args);
	}

}
