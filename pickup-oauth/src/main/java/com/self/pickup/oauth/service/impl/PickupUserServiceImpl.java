package com.self.pickup.oauth.service.impl;

import com.self.pickup.oauth.domain.PickupUser;
import com.self.pickup.oauth.mapper.PickupUserMapper;
import com.self.pickup.oauth.service.PickupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

public class PickupUserServiceImpl implements PickupUserService {

    @Autowired
    private PickupUserMapper pickupUserMapper;

    @Override
    public PickupUser getUserByUsername(String account) {
        Example example = new Example(PickupUser.class);
        example.createCriteria().andEqualTo("account", account);

        PickupUser pickupUser = pickupUserMapper.selectOneByExample(example);

        if(pickupUser.equals(null)){
            return null;
        }

        return pickupUser;
    }
}
