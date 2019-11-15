package com.self.pickup.provider.sso.mapper;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.provider.sso.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends MyMapper<User> {
}