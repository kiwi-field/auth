package net.trueland.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 大誌
 * @Date 2019/4/7 15:20
 * @Version 1.0
 */
@Api(tags = "测试")
@RestController("/test")
public class TestController {

    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresPermissions({"save"})
    @PostMapping("/save")
    @ApiOperation(value = "测试是否有save权限", notes = "参数:token")
    public Map<String, Object> save(@RequestHeader("token")String token) {
        System.out.println("save");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有save的权力");
        return map;
    }

    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresPermissions({"delete"})
    @DeleteMapping("/delete")
    @ApiOperation(value = "测试是否有delete权限", notes = "参数:token")
    public Map<String, Object> delete(@RequestHeader("token")String token) {
        System.out.println("delete");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有delete的权力");
        return map;
    }

    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresPermissions({"update"})
    @PutMapping("update")
    @ApiOperation(value = "测试是否有update权限", notes = "参数:token")
    public Map<String, Object> update(@RequestHeader("token")String token) {
        System.out.println("update");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有update的权力");
        return map;
    }


    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresPermissions({"select"})
    @GetMapping("select")
    @ApiOperation(value = "测试是否有select权限", notes = "参数:token")
    public Map<String, Object> select(@RequestHeader("token")String token) {
        System.out.println("select");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有select的权力");
        return map;
    }


    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresRoles({"管理员"})
    @GetMapping("/admin")
    @ApiOperation(value = "测试是否有管理员角色", notes = "参数:token")
    public Map<String, Object> vip(@RequestHeader("token")String token) {
        System.out.println("admin");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有管理员角色");
        return map;
    }


    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresRoles({"超级管理员"})
    @GetMapping("/superAdmin")
    @ApiOperation(value = "测试是否有超级管理员角色", notes = "参数:token")
    public Map<String, Object> svip(@RequestHeader("token")String token) {
        System.out.println("superAdmin");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有超级管理员角色");
        return map;
    }

    /**
     * 没有的话 AuthorizationException
     * @param token
     * @return
     */
    @RequiresRoles({"普通用户"})
    @GetMapping("/p")
    @ApiOperation(value = "测试是否有普通用户角色", notes = "参数:token")
    public Map<String, Object> p(@RequestHeader("token")String token) {
        System.out.println("p");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("msg", "当前用户有P角色");
        return map;
    }
}
