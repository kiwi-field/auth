package net.trueland.realm;

import net.trueland.entity.Resource;
import net.trueland.entity.Role;
import net.trueland.entity.SysToken;
import net.trueland.entity.User;
import net.trueland.repository.ResourceRepository;
import net.trueland.repository.RoleRepository;
import net.trueland.repository.UserRepository;
import net.trueland.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserRepository userRepository;

    @Autowired
	private RoleRepository roleRepository;

    @Autowired
	private ResourceRepository resourceRepository;

    @Autowired
    private ShiroService shiroService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roleList = roleRepository.findByUserId(user.getId());
        Set<String> roles = new HashSet<String>();
        for (Role role : roleList) {
            roles.add(role.getName());
            List<Resource> resourceList = resourceRepository.findByRoleId(role.getId());
            for (Resource resource : resourceList) {
                info.addStringPermission(resource.getPermission());
            }
        }
        info.setRoles(roles);
        return info;
    }

	/**
	 * 身份权限认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取token，既前端传入的token
        String accessToken = (String) token.getPrincipal();
        //1. 根据accessToken，查询用户信息
        SysToken tokenEntity = shiroService.findByToken(accessToken);
        //2. token失效
        if (tokenEntity == null || tokenEntity.getExpireTime().isBefore(LocalDateTime.now())) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        User user = shiroService.findByUserId(tokenEntity.getUserId());
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (user == null) {
            throw new UnknownAccountException("用户不存在!");
        }
        //5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());
        return info;
	}

}
