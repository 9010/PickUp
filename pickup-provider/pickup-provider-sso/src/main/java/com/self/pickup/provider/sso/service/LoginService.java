package com.self.pickup.provider.sso.service;

import com.self.pickup.common.domain.PickupUser;

/**
 * 登录业务
 */
public interface LoginService {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public PickupUser login(String loginCode, String plantPassword);
}
