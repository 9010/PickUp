package com.self.pickup.provider.sso.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.service.LoginService;
import com.self.pickup.provider.sso.service.consumer.RedisCacheService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
//@RequestMapping(value = "sso")
public class LoginController {

//    @Autowired
//    private RedisCacheService redisService;

    @Autowired
    private LoginService loginService;

//    /**
//     * 检查是否登陆
//     * @param account
//     * @param password
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "checkLogin")
//    public String checkLogin(String account, String password){
//        return loginService.haveLogin(account, password);
//    }

    /**
     * 登录业务
     *
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody JSONObject jsonParam) {
        String account = jsonParam.getString("account");
        String password = jsonParam.getString("password");

        String message = loginService.login(account, password);

        // 登录失败
        if (message != "ok") {
            try {
                // 错误信息返回前端
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("SSO", message))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 登录成功
        else {
            String token = UUID.randomUUID().toString();
            User user = loginService.getOneByAccount(account);
            // 先将redis有关内容注释，建立redis服务器后再使用
            // 将 Token 放入缓存
//            String result = redisService.put(token, account, 60 * 60 * 24 * 7);
//            if (StringUtils.isNotBlank(result) && "ok".equals(result)) {
            user.setToken(token);  // token放入对象
            loginService.updateByPrimaryKey(user);
            try {
                return MapperUtils.obj2json(BaseResult.ok(user)); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
//            }

            // redis熔断处理，服务器内部错误
//            else {
//                return BaseResult.notOk(Lists.newArrayList(
//                        new BaseResult.Error("ServerError","服务器错误，请稍后再试")));
//            }
        }

        // 服务器出错处理
        try {
            return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("SSO","内部错误"))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Exception!";
    }

    /**
     * 注销
     *
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(@RequestBody JSONObject jsonParam) {
        String account = jsonParam.getString("account");
        User user = loginService.getOneByAccount(account);
        if(user == null){
            try {
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("Logout","不存在的账号"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            user.setToken("");
            loginService.updateByPrimaryKey(user);
            try {
                return MapperUtils.obj2json(BaseResult.ok()); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }
}
