package com.self.pickup.provider.parent.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.mapper.ParentMapper;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl extends BaseServiceImpl<Parent, Integer> implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    @Override
    public MyMapper<Parent> getMapper() {
        return parentMapper;
    }
}
