package com.self.pickup.provider.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.self.pickup.provider.sso.mapper")
public class PickupProviderSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderSsoApplication.class, args);
    }

}
