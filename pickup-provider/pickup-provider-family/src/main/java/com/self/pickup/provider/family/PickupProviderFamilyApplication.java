package com.self.pickup.provider.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class PickupProviderFamilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderFamilyApplication.class, args);
    }

}
