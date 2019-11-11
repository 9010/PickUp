package com.self.pickup.provider.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.user.service.PickupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private PickupUserService pickupUserService;

    /**
     * 注册业务
     *
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody JSONObject jsonParam) {
        String account = jsonParam.getString("account");
        String password = jsonParam.getString("password");
        String schoolId = jsonParam.getString("schoolId");
        String creditId = jsonParam.getString("creditId");

        PickupUser pickupUser = new PickupUser(account, password, schoolId, creditId);

        int success = pickupUserService.add(pickupUser);
        if(success == 1){
            try {
                return MapperUtils.obj2json(BaseResult.ok(pickupUser)) ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            // 出错处理
            try {
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("register","网络错误"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }
}
