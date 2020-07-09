package net.trueland.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.trueland.dto.LoginDTO;
import net.trueland.entity.User;
import net.trueland.service.ShiroService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author dengxiaoyu
 * @Date 2019/3/30 22:04
 * @Version 1.0
 */
@Api(tags = "Shiro权限管理")
@RestController
public class ShiroController {

    private final ShiroService shiroService;

    public ShiroController(ShiroService shiroService) {
        this.shiroService = shiroService;
    }


    /**
     * 登录
     */
    @ApiOperation(value = "登陆", notes = "参数:用户名 密码")
    @PostMapping("/sys/login")
    public Map<String, Object> login(//@RequestBody
                                         @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        //用户信息
        User user = shiroService.findByUsername(username);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            //生成token，并保存到数据库
            result = shiroService.createToken(user.getId());
            result.put("status", 200);
            result.put("msg", "登陆成功");
        }
        return result;
    }

    /**
     * 退出
     */
    @ApiOperation(value = "登出", notes = "参数:token")
    @PostMapping("/sys/logout")
    public Map<String, Object> logout(@RequestHeader("token")String token) {
        Map<String, Object> result = new HashMap<>();
        shiroService.logout(token);
        result.put("status", 200);
        result.put("msg", "您已安全退出系统");
        return result;
    }

    @ApiOperation(value = "hello", notes = "参数:token")
    @PostMapping("/sys/hello")
    public Map<String, Object> hello(@RequestHeader("token")String token) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("msg", "您已登录，hello");
        return result;
    }
}


