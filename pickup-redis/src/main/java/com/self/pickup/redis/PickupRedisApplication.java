package com.self.pickup.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PickupRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupRedisApplication.class, args);
    }

}
