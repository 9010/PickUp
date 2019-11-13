package com.self.pickup.provider.sso.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign调用Student微服务的接口
 */
@Component
@FeignClient(value = "pickup-provider-student")
public interface GetStudentService {

    @RequestMapping(value = "student/checkCreditId")
    public boolean checkCreditId(String creditId);
}
