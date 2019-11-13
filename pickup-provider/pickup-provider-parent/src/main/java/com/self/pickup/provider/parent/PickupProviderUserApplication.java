package com.self.pickup.provider.parent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.self.pickup.common.mapper"})
public class PickupProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderUserApplication.class, args);
    }

}
