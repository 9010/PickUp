package com.self.pickup.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PickupEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupEurekaApplication.class, args);
    }

}
