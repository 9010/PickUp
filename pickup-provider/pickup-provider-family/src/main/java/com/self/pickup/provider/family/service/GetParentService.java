package com.self.pickup.provider.family.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "pickup-provider-parent")
public interface GetParentService {

    @RequestMapping(value = "")
    public String getFamilyParent(@RequestParam("parentName") String parentName,
                                  @RequestParam("familyId") String familyId);
}
