package com.self.pickup.oauth.service;

import com.self.pickup.oauth.domain.PickupUser;
import com.self.pickup.oauth.mapper.PickupUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PickupUserService {
    public PickupUser getUserByAccount(String account);
}
