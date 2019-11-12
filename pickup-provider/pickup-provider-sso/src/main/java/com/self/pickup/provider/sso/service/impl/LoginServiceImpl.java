package com.self.pickup.provider.sso.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.sso.domain.PickupUser;
import com.self.pickup.provider.sso.mapper.PickupUserMapper;
import com.self.pickup.provider.sso.service.LoginService;
import com.self.pickup.provider.sso.service.consumer.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
public class LoginServiceImpl extends BaseServiceImpl<PickupUser, Integer> implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private PickupUserMapper pickupUserMapper;

    @Override
    public MyMapper<PickupUser> getMapper(){
        return pickupUserMapper;
    }

    /**
     * 登录
     * @param account
     * @param plantPassword
     * @return
     */
    @Override
    public String login(String account, String plantPassword) {
        PickupUser pickupUser = null;

        // 先不使用redis，直接从数据库取数据
        // 从数据库中找到account数据
        Example example = new Example(PickupUser.class);
        example.createCriteria().andEqualTo("account", account);
        pickupUser = pickupUserMapper.selectOneByExample(example);

        String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());

        // 检查是否取出数据，以及密码是否对应匹配
        if (pickupUser != null && password.equals(pickupUser.getPassword())) {
            return "ok";
        }
        else if(pickupUser == null){
            return "不存在此账号，请先注册";
        }
        else if(!password.equals(pickupUser.getPassword())){
            return "密码错误，请重新输入";
        }
        else{
            return "内部错误";
        }
    }

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Override
    public PickupUser getOneByAccount(String account) {
        PickupUser pickupUser = null;

        // 从数据库中找到account数据
        Example example = new Example(PickupUser.class);
        example.createCriteria().andEqualTo("account", account);
        pickupUser = pickupUserMapper.selectOneByExample(example);

        return pickupUser;
    }

//    @Autowired
//    private RedisCacheService redisService;
//
//    @Autowired
//    private PickupUserMapper pickupUserMapper;
//
//    @Override
//    public MyMapper<PickupUser> getMapper(){
//        return pickupUserMapper;
//    }
//
//    @Override
//    public PickupUser login(String account, String plantPassword) {
//        PickupUser pickupUser = null;
//
//        String json = redisService.get(account);
//
//        // 缓存中没有数据，从数据库取数据
//        if (json == null) {
//            // 从数据库中找到account数据
//            Example example = new Example(PickupUser.class);
//            example.createCriteria().andEqualTo("account", account);
//            pickupUser = pickupUserMapper.selectOneByExample(example);
//
//            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
//
//            // 检查是否取出数据，以及密码是否对应匹配
//            if (pickupUser != null && password.equals(pickupUser.getPassword())) {
//                try {
//                    // 存入redis
//                    redisService.put(account, MapperUtils.obj2json(pickupUser), 60 * 60 * 24 * 7);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return pickupUser;
//            }
//
//            else {
//                return null;
//            }
//        }
//
//        // 缓存中有数据
//        else {
//            try {
//                // 从redis中取出数据返回
//                pickupUser = MapperUtils.json2pojo(json, PickupUser.class);
//            } catch (Exception e) {
//                logger.warn("触发熔断：{}", e.getMessage());
//            }
//        }
//
//        return pickupUser;
//    }
}
