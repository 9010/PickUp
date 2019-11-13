package com.self.pickup.common.inteceptor;

import com.self.pickup.common.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private SsoService ssoService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        // 从http请求头中取出token
        String token = httpServletRequest.getParameter("token");
        String account = httpServletRequest.getParameter("account");

        // 执行认证
        String message = ssoService.checkLogin(account, token);
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
