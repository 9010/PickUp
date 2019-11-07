package com.self.pickup.provider.user.service.impl;

import com.self.pickup.provider.user.domain.PickupUser;
import com.self.pickup.provider.user.mapper.PickupUserMapper;
import com.self.pickup.provider.user.service.PickupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

public class PickupUserServiceImpl implements PickupUserService {

    @Autowired
    private PickupUserMapper pickupUserMapper;

    @Override
    public PickupUser getUserByAccount(String account) {
        Example example = new Example(PickupUser.class);
        example.createCriteria().andEqualTo("account", account);

        PickupUser pickupUser = pickupUserMapper.selectOneByExample(example);

        if(pickupUser.equals(null)){
            return null;
        }

        return pickupUser;
    }
}
