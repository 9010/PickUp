package com.self.pickup.provider.parent.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.mapper.ParentMapper;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ParentServiceImpl extends BaseServiceImpl<Parent, Integer> implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    @Override
    public MyMapper<Parent> getMapper() {
        return parentMapper;
    }

    /**
     * 根据账号获取个人信息
     * @param account
     * @return
     */
    @Override
    public Parent getInfoByAccount(String account) {
        Parent parent = null;

        // 从数据库中找到数据
        Example example = new Example(Parent.class);
        example.createCriteria().andEqualTo("account", account);
        parent = parentMapper.selectOneByExample(example);

        return parent;
    }

    /**
     * 根据家庭ID获取家长信息
     * @param familyId 家庭ID
     * @return List
     */
    @Override
    public List<Parent> getParentByFamilyId(String familyId) {
        List<Parent> parents = null;

        // 从数据库中找到数据
        Example example = new Example(Parent.class);
        example.createCriteria().andEqualTo("familyId", familyId);
        parents = parentMapper.selectByExample(example);

        return parents;
    }
}
