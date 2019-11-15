package com.self.pickup.provider.family.service;

import com.self.pickup.common.dto.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "pickup-provider-parent")
public interface GetParentService {

    /**
     * 根据家庭ID获取家长列表
     * @param familyId
     * @return
     */
    @RequestMapping(value = "/internal/getFamilyParent")
    public BaseResult getFamilyParent(@RequestParam("familyId") String familyId);
}
