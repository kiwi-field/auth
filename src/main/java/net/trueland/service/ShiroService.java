package net.trueland.service;



import net.trueland.entity.SysToken;
import net.trueland.entity.User;

import java.util.Map;

/**
 * @Author dengxiaoyu
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
public interface ShiroService {
     /**
      * Find user by username
      * @param username
      * @return
      */
     User findByUsername(String username);

     /**
      * create token by userId
      * @param userId
      * @return
      */
     Map<String,Object> createToken(Integer userId);

     /**
      * logout
      * @param token
      */
     void logout(String token);

     /**
      * find token by token
      * @param accessToken
      * @return
      */
     SysToken findByToken(String accessToken);

     /**
      * find user by userId
      * @param userId
      * @return
      */
     User findByUserId(Integer userId);
}
