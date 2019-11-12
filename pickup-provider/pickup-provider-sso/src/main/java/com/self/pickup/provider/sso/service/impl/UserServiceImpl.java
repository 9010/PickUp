package com.self.pickup.provider.sso.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.mapper.UserMapper;
import com.self.pickup.provider.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MyMapper<User> getMapper() {
        return userMapper;
    }

}
