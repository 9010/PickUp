package com.self.pickup.provider.sso.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用Student微服务的接口
 */
@Component
@FeignClient(value = "pickup-provider-student")
public interface GetStudentService {

    @RequestMapping(value = "checkCreditId")
    public boolean checkCreditId(@RequestParam("creditId") String creditId);
}
