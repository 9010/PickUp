package com.self.pickup.provider.parent.service;

import com.self.pickup.common.service.BaseService;
import com.self.pickup.provider.parent.domain.Parent;

import java.util.List;

public interface ParentService extends BaseService<Parent, Integer> {
    /**
     * 根据账号获取个人信息
     * @param account 账号
     * @return Parent
     */
    public Parent getInfoByAccount(String account);

    /**
     * 根据家庭ID获取家长信息
     * @param familyId 家庭ID
     * @return List
     */
    public List<Parent> getParentByFamilyId(String familyId);
}
