package com.self.pickup.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PickupZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickupZipkinApplication.class, args);
	}

}
