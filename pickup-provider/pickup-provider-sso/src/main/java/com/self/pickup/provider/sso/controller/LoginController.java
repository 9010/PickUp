package com.self.pickup.provider.sso.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.CookieUtils;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.service.LoginService;
import com.self.pickup.provider.sso.service.consumer.RedisCacheService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {

//    @Autowired
//    private RedisCacheService redisService;

    @Autowired
    private LoginService loginService;

    /**
     * 检查是否已登陆
     *
     * @return
     */
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public BaseResult login(
//            @RequestParam(required = true) String account,
//            @RequestParam(required = false) String url,
//            HttpServletRequest request) {
//        String token = CookieUtils.getCookieValue(request, "token");
//
//        // token 不为空可能已登录
//        if (StringUtils.isNotBlank(token)) {
//            String redisAccount = redisService.get(token);
//            // 检查token是否在redis中存在，检查account是否与redis中的相同
//            if (StringUtils.isNotBlank(redisAccount) && redisAccount.equals(account)) {
//                String json = redisService.get(account);  //从redis中取出account的内容
//                if (StringUtils.isNotBlank(json)) {
//                    try {
//                        PickupUser pickupUser = MapperUtils.json2pojo(json, PickupUser.class); //json转成object
//                        // 已登录
//                        if (pickupUser != null) {
//                            // sso已登陆，返回success标签即可
//                            return BaseResult.ok();
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//        return BaseResult.notOk(Lists.newArrayList(
//                new BaseResult.Error("SSO","未登陆")));
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
                MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("SSO", message))));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // 登录成功
        else {
            String token = UUID.randomUUID().toString();
            PickupUser pickupUser = loginService.getOneByAccount(account);
            // 先将redis有关内容注释，建立redis服务器后再使用
            // 将 Token 放入缓存
//            String result = redisService.put(token, account, 60 * 60 * 24 * 7);
//            if (StringUtils.isNotBlank(result) && "ok".equals(result)) {
            pickupUser.setToken(token);  // token放入对象
            try {
                return MapperUtils.obj2json(BaseResult.ok(pickupUser)); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
//            }

            // 熔断处理，服务器内部错误
//            else {
//                return BaseResult.notOk(Lists.newArrayList(
//                        new BaseResult.Error("ServerError","服务器错误，请稍后再试")));
//            }
        }

        // 出错处理
        try {
            return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("SSO","网络错误"))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Exception!";
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
//    @RequestMapping(value = "logout", method = RequestMethod.GET)
//    public String logout(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String url, Model model) {
//        try {
//            CookieUtils.deleteCookie(request, response, "token");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (StringUtils.isNotBlank(url)) {
//            return "redirect:/login?url=" + url;
//        } else {
//            return "redirect:/login";
//        }
//    }
}
