package com.fd.springbootdemo.shiro;

import com.fd.springbootdemo.entity.OmUser;
import com.fd.springbootdemo.service.UserService;
import com.fd.springbootdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author xyl
 * @Create 2018-09-19 12:09
 * @Desc 写点注释吧
 **/
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权(权限控制)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        OmUser user = (OmUser) principals.getPrimaryPrincipal();
//        for(OmRole role:roleService.findByUserId(user.getUserId())){
//            authorizationInfo.addRole(role.getRole());
//            for(Permission p:rolePermissionService.findByRoleId(role.getId())){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
//        return authorizationInfo;
        return new SimpleAuthorizationInfo();
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
        OmUser user = userService.findUser(username);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user,   //认证通过后，存放在session,一般存放user对象
                    user.getPassword(),   //用户数据库中的密码
                    //ByteSource.Util.bytes(username),//salt=username+salt，使用盐值加密一定要加
                    getName());    //返回Realm名
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(Constant.USER_SESSION_KEY, user);
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
