package com.self.pickup.provider.sso.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用Parent微服务的接口
 */
@Component
@FeignClient(value = "pickup-provider-parent")
public interface GetParentService {

    @RequestMapping(value = "parent/addRegister")
    public int addRegister(@RequestParam("account") String account,
                           @RequestParam("familyId") String familyId);
}
