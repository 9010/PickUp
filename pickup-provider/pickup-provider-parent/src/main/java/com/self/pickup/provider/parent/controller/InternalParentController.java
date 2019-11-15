package com.self.pickup.provider.parent.controller;

import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "internal")
public class InternalParentController {

    @Autowired
    private ParentService parentService;

    /**
     * 注册时添加家长
     * @param account 账号
     * @param familyId 家庭ID
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "addRegister")
    public int addRegister(@RequestParam("account") String account,
                           @RequestParam("familyId") String familyId){

        Parent parent = new Parent(account, "", null,
                "", null, familyId, "");

        int success = parentService.add(parent);

        return success;
    }

    public String
}
