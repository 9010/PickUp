package com.self.pickup.provider.family.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.family.domain.Family;
import com.self.pickup.provider.family.mapper.FamilyMapper;
import com.self.pickup.provider.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl extends BaseServiceImpl<Family, Integer> implements FamilyService {
    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public MyMapper<Family> getMapper() {
        return familyMapper;
    }
}
