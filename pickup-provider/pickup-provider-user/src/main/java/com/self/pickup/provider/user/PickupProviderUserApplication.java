package com.self.pickup.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PickupProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderUserApplication.class, args);
    }

}
