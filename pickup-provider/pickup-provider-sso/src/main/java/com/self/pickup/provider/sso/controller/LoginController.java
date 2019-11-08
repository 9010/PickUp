package com.self.pickup.provider.sso.controller;

import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.utils.CookieUtils;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.service.LoginService;
import com.self.pickup.provider.sso.service.consumer.RedisCacheService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private RedisCacheService redisService;

    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @RequestParam(required = false) String url,
            HttpServletRequest request, Model model) {
        String token = CookieUtils.getCookieValue(request, "token");

        // token 不为空可能已登录
        if (StringUtils.isNotBlank(token)) {
            String account = redisService.get(token);
            if (StringUtils.isNotBlank(account)) {
                String json = redisService.get(account);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        PickupUser pickupUser = MapperUtils.json2pojo(json, PickupUser.class);
                        // 已登录
                        if (pickupUser != null) {
                            if (StringUtils.isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                        }

                        // 将登录信息传到登录页
                        model.addAttribute("pickupUser", pickupUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }

        return "login";
    }

    /**
     * 登录业务
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(required = true) String account,
            @RequestParam(required = true) String password,
            @RequestParam(required = false) String url,
            HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        PickupUser pickupUser = loginService.login(account, password);

        // 登录失败
        if (pickupUser == null) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入");
        }

        // 登录成功
        else {
            String token = UUID.randomUUID().toString();

            // 将 Token 放入缓存
            String result = redisService.put(token, account, 60 * 60 * 24);
            if (StringUtils.isNotBlank(result) && "ok".equals(result)) {
                CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
                if (StringUtils.isNotBlank(url)) {
                    return "redirect:" + url;
                }
            }

            // 熔断处理
            else {
                redirectAttributes.addFlashAttribute("message", "服务器异常，请稍后再试");
            }
        }

        return "redirect:/login";
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String url, Model model) {
        try {
            CookieUtils.deleteCookie(request, response, "token");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotBlank(url)) {
            return "redirect:/login?url=" + url;
        } else {
            return "redirect:/login";
        }
    }
}
