package com.self.pickup.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class PickupConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupConfigApplication.class, args);
    }

}
