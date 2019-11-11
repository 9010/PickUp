package com.self.pickup.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.self.pickup.common.mapper"})
public class PickupProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderUserApplication.class, args);
    }

}
