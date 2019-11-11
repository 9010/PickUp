package com.self.pickup.provider.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.self.pickup.common.mapper"})
public class PickupProviderSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderSsoApplication.class, args);
    }

}
