package com.self.pickup.provider.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.self.pickup.provider.student.mapper"})
public class PickupProviderStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupProviderStudentApplication.class, args);
    }

}
