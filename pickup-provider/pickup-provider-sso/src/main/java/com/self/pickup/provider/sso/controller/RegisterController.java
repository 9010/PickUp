package com.self.pickup.provider.sso.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class RegisterController {
    @Autowired
    private UserService UserService;

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

        User User = new User(account, password, schoolId, creditId);

        int success = UserService.add(User);
        if(success == 1){
            try {
                return MapperUtils.obj2json(BaseResult.ok(User)) ;
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
