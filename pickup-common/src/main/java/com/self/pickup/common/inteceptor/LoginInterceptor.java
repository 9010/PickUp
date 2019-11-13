package com.self.pickup.common.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.service.LoginService;
import com.self.pickup.provider.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        // 从http请求头中取出token
        String token = httpServletRequest.getParameter("token");
        String account = httpServletRequest.getParameter("account");

        // 执行认证
        String message = loginService.haveLogin(account, token);
        if(message == "ok"){
            return true;
        }
        else {
            throw new RuntimeException(message);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
