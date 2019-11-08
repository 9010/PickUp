package com.self.pickup.provider.sso.service;

import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.service.BaseService;

/**
 * 登录业务
 */
public interface LoginService extends BaseService<PickupUser, Integer> {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public PickupUser login(String loginCode, String plantPassword);
}
