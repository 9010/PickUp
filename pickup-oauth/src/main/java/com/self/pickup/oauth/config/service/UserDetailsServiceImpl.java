package com.self.pickup.oauth.config.service;

import com.self.pickup.oauth.domain.PickupUser;
import com.self.pickup.oauth.service.PickupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PickupUserService pickupUserService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        PickupUser pickupUser = pickupUserService.getUserByUsername(account);
        //验证账户为username的用户是否存在
        if (null == pickupUser){
            throw new UsernameNotFoundException("username:  " + account + "is not exist!");
        }

        //返回认证用户
        return new User(pickupUser.getAccount(), pickupUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}