package com.self.pickup.provider.sso.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.service.GetParentService;
import com.self.pickup.provider.sso.service.GetStudentService;
import com.self.pickup.provider.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value = "sso")
public class RegisterController {
    @Autowired
    private UserService UserService;

    @Autowired
    private GetStudentService getStudentService;

    @Autowired
    private GetParentService getParentService;

    /**
     * 注册业务
     *
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestBody JSONObject jsonParam) {
        String account = jsonParam.getString("account");
        String password = jsonParam.getString("password");
        String creditId = jsonParam.getString("creditId");

        // 检查学籍号是否正确
        boolean checkCreditId = getStudentService.checkCreditId(creditId);
        // 学籍号正确
        if(checkCreditId) {
            User User = new User(account, password, creditId);

            // 数据插入PickUp_User数据库
            int success_user = UserService.add(User);
            // 数据插入PickUp_Parent数据库
            int success_parent = getParentService.addRegister(account, account);

            // 插入数据库均成功，返回前端
            if (success_user == 1 && success_parent == 1) {
                try {
                    return MapperUtils.obj2json(BaseResult.ok(User));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // 出错处理
                try {
                    return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                            new BaseResult.Error("register", "网络错误"))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 学籍号错误
        else {
            // 出错处理
            try {
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("register", "学籍号错误"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }
}
