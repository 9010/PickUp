package com.self.pickup.provider.parent.service;

import com.self.pickup.common.service.BaseService;
import com.self.pickup.provider.parent.domain.Parent;

public interface ParentService extends BaseService<Parent, Integer> {
    /**
     * 根据账号获取个人信息
     * @param account
     * @return
     */
    public Parent getInfoByAccount(String account);
}
