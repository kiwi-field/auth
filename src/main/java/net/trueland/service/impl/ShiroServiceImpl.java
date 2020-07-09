package net.trueland.service.impl;


import net.trueland.auth.TokenGenerator;
import net.trueland.entity.SysToken;
import net.trueland.entity.User;
import net.trueland.repository.SysTokenRepository;
import net.trueland.repository.UserRepository;
import net.trueland.service.ShiroService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author dengxiaoyu
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    /**
     * 12小时后失效
     */
    private final static int EXPIRE = 12;


    private final UserRepository userRepository;
    private final SysTokenRepository sysTokenRepository;

    public ShiroServiceImpl(UserRepository userRepository, SysTokenRepository sysTokenRepository) {
        this.userRepository = userRepository;
        this.sysTokenRepository = sysTokenRepository;
    }

    /**
     * 根据username查找用户
     *
     * @param username
     * @return User
     */
    @Override
    public User findByUsername(String username, Integer companyId) {
        User user = userRepository.findByUserName(username, companyId);
        return user;
    }


    @Override
    /**
     * 生成一个token
     *@param  [userId]
     *@return Result
     */
    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>(2);
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //判断是否生成过token
        SysToken tokenEntity = sysTokenRepository.findByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            //保存token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        } else {
            //更新token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        }
        sysTokenRepository.save(tokenEntity);
        result.put("token", token);
        result.put("expire", expireTime);
        return result;
    }

    /**
     * 更新数据库的token，使前端拥有的token失效
     * 防止黑客利用token搞事情
     *
     * @param token
     */
    @Override
    public void logout(String token) {
        SysToken byToken = findByToken(token);
        //生成一个token
        token = TokenGenerator.generateValue();
        //修改token
        byToken.setToken(token);
        //使前端获取到的token失效
        sysTokenRepository.save(byToken);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenRepository.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User u = null;
        if (userOptional.isPresent()) {
            u = userOptional.get();
        }
        return u;
    }
}
