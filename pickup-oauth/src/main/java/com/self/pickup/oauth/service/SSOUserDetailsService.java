package com.self.pickup.oauth.service;

import com.self.pickup.oauth.domain.PickupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SSOUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PickupUserService pickupUserService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
//        PickupUser pickupUser = pickupUserService.getUserByAccount(account);
//        if( null == pickupUser ) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        return new User(pickupUser.getAccount(), passwordEncoder.encode(pickupUser.getPassword()),
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        String user = "user";
        if( account != user ) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(account, passwordEncoder.encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
