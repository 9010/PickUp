package com.self.pickup.provider.sso.service;

import com.self.pickup.common.service.BaseService;
import com.self.pickup.provider.sso.domain.User;

/**
 * 登录业务
 */
public interface LoginService extends BaseService<User, Integer> {

    /**
     * 登录
     * @param account
     * @param plantPassword
     * @return
     */
    public String login(String account, String plantPassword);

    /**
     * 检查是否已登录
     * @param account
     * @param token
     * @return
     */
    public String haveLogin(String account, String token);

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    public User getOneByAccount(String account);
}
