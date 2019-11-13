package com.self.pickup.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "pickup-provider-sso")
public interface SsoService {

    @RequestMapping("checkLogin")
    public String checkLogin(String account, String token);
}
