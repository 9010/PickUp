package com.self.pickup.provider.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "parent")
public class UserController {
    @Autowired
    private ParentService parentService;

    @ResponseBody
    @RequestMapping(value = "getPersonInfo", method = RequestMethod.POST)
    public String getPersonInfo(@RequestBody JSONObject jsonParam){
        String account = jsonParam.getString("account");

        Parent parent = null;

        parent = parentService.getInfoByAccount(account);
        if(parent == null){
            try {
                // 错误信息返回前端
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("parent", "账号不存在"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                // 数据返回前端
                return MapperUtils.obj2json(BaseResult.ok(parent)); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }
}
