package com.self.pickup.provider.parent.controller;

import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 根据家庭ID获取家长列表
     * @param familyId 家庭ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getFamilyParent")
    public BaseResult getFamilyParent(@RequestParam("familyId") String familyId){
        List<Parent> parents = parentService.getParentByFamilyId(familyId);

        // 找到家长列表，返回给family服务
        if(parents != null){
            return BaseResult.ok(parents);
        }
        // 出错处理
        else{
            return BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("parent", "familyId不存在")));
        }
    }
}
