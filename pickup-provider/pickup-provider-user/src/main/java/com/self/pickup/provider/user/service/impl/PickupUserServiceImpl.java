package com.self.pickup.provider.user.service.impl;

import com.self.pickup.common.domain.PickupUser;
import com.self.pickup.common.mapper.PickupUserMapper;
import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.user.service.PickupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickupUserServiceImpl extends BaseServiceImpl<PickupUser, Integer> implements PickupUserService {

    @Autowired
    private PickupUserMapper pickupUserMapper;

    @Override
    public MyMapper<PickupUser> getMapper() {
        return pickupUserMapper;
    }

}
