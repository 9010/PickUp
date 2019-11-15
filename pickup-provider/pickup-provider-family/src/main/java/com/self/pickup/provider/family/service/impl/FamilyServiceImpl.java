package com.self.pickup.provider.family.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.family.domain.Family;
import com.self.pickup.provider.family.mapper.FamilyMapper;
import com.self.pickup.provider.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class FamilyServiceImpl extends BaseServiceImpl<Family, Integer> implements FamilyService {
    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public MyMapper<Family> getMapper() {
        return familyMapper;
    }

    /**
     * 根据账号获取个人信息
     * @param account
     * @return Family
     */
    @Override
    public Family getInfoByAccount(String account) {
        Family family = null;

        // 从数据库中找到数据
        Example example = new Example(Family.class);
        example.createCriteria().andEqualTo("account", account);
        family = familyMapper.selectOneByExample(example);

        return family;
    }
}
