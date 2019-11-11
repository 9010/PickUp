package com.self.pickup.provider.sso.service;

import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.service.BaseService;

/**
 * 登录业务
 */
public interface LoginService extends BaseService<PickupUser, Integer> {

    /**
     * 登录
     * @param account
     * @param plantPassword
     * @return
     */
    public String login(String account, String plantPassword);

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    public PickupUser getOneByAccount(String account);
}
