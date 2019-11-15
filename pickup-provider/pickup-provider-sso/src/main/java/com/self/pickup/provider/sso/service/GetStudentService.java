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

    /**
     * 检查学籍号
     * @param creditId 学籍号
     * @return boolean
     */
    @RequestMapping(value = "internal/checkCreditId")
    public boolean checkCreditId(@RequestParam("creditId") String creditId);

    /**
     * 设置学生的家庭ID
     * @param creditId 学籍号
     * @param familyId 家庭ID
     * @return int
     */
    @RequestMapping(value = "internal/setFamilyId")
    public int setFamilyID(@RequestParam("creditId") String creditId,
                              @RequestParam("familyId") String familyId);
}
