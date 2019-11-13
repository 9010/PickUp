package com.self.pickup.provider.sso.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.sso.domain.User;
import com.self.pickup.provider.sso.mapper.UserMapper;
import com.self.pickup.provider.sso.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
public class LoginServiceImpl extends BaseServiceImpl<User, Integer> implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public MyMapper<User> getMapper(){
        return userMapper;
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public String login(String account, String password) {
        User user = null;

        // 先不使用redis，直接从数据库取数据
        // 从数据库中找到account数据
        user = getOneByAccount(account);

        // 检查是否取出数据，以及密码是否对应匹配
        if (user != null && password.equals(user.getPassword())) {
            return "ok";
        }
        else if(user == null){
            return "不存在此账号，请先注册";
        }
        else if(!password.equals(user.getPassword())){
            return "密码错误，请重新输入";
        }
        else{
            return "内部错误";
        }
    }

    /**
     * 检查是否已登录
     * @param account
     * @param token
     * @return
     */
    @Override
    public String haveLogin(String account, String token) {
        User user = null;
        user =getOneByAccount(account);

        if(user != null && token == user.getToken()){
            return "ok";
        }
        else if(token == null || token == "" || account == null || account == ""){
            return "用户未登陆，请先登陆";
        }
        else if(user == null){
            return "此账号已被注销";
        }
        else if(token != user.getToken()){
            return "此账号在已在其他设备登陆，请重新登陆";
        }
        else {
            return "内部错误";
        }
    }

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Override
    public User getOneByAccount(String account) {
        User User = null;

        // 从数据库中找到account数据
        Example example = new Example(User.class);
        //存在account并且未被注销
        example.createCriteria().andEqualTo("account", account).andEqualTo("removed", false);
        User = userMapper.selectOneByExample(example);

        return User;
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
