package com.fd.springbootdemo.shiro;

import com.fd.springbootdemo.entity.Permission;
import com.fd.springbootdemo.entity.Role;
import com.fd.springbootdemo.entity.User;
import com.fd.springbootdemo.mapper.RolePermissionMapper;
import com.fd.springbootdemo.service.RolePermissionService;
import com.fd.springbootdemo.service.RoleService;
import com.fd.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author xyl
 * @Create 2018-09-19 12:09
 * @Desc 写点注释吧
 **/
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    public UserService userService;
    @Autowired
    public RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 授权(权限控制)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        for(Role role:roleService.findByUserId(user.getUid())){
            authorizationInfo.addRole(role.getRole());
            for(Permission p:rolePermissionService.findByRoleId(role.getId())){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 登入验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString();
        User user = userService.findUser(username);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user,   //认证通过后，存放在session,一般存放user对象
                    user.getPassword(),   //用户数据库中的密码
                    //ByteSource.Util.bytes(username),//salt=username+salt，使用盐值加密一定要加
                    getName());    //返回Realm名
            return authenticationInfo;
        }
        return null;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123456";//密码原值
        Object salt = "admin";//盐值
        int hashIterations = 1;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        System.out.println(result);
    }
}
