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

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 执行认证
        if (token == null || token == "") {
            throw new RuntimeException("用户未登陆，请先登录");
        }
        // 获取http请求头中的account
        String account = httpServletRequest.getParameter("account");
        if (account == null) {
            throw new RuntimeException("用户未登陆，请先登录");
        }
        else{
            User user = loginService.getOneByAccount(account);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            //验证用户是否有token
            if(user.getToken() == null || user.getToken() == ""){
                throw new RuntimeException("用户未登陆，请先登录");
            }
            //验证token是否相同
            else if(token != user.getToken()){
                throw new RuntimeException("用户已在其他设备登陆，请重新登陆");
            }
            //token相同，认证通过
            return true;
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
