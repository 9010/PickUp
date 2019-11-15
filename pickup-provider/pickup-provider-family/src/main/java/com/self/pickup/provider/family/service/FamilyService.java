package com.self.pickup.provider.family.service;

import com.self.pickup.common.service.BaseService;
import com.self.pickup.provider.family.domain.Family;

public interface FamilyService extends BaseService<Family, Integer> {
    /**
     * 根据账号获取个人信息
     * @param account 账号
     * @return Parent
     */
    public Family getInfoByAccount(String account);
}
