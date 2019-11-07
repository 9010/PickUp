package com.self.pickup.provider.user.service;

import com.self.pickup.provider.user.domain.PickupUser;
import org.springframework.stereotype.Service;

@Service
public interface PickupUserService {
    public PickupUser getUserByAccount(String account);
}
