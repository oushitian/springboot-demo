package com.fd.springbootdemo.shiro;

import com.fd.springbootdemo.entity.OmPermis;
import com.fd.springbootdemo.entity.OmRole;
import com.fd.springbootdemo.entity.OmUser;
import com.fd.springbootdemo.service.PermisService;
import com.fd.springbootdemo.service.RoleService;
import com.fd.springbootdemo.service.UserService;
import com.fd.springbootdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author xyl
 * @Create 2018-09-19 12:09
 * @Desc 写点注释吧
 **/
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermisService permisService;

    /**
     * 授权(权限控制)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        // 获取登录时输入的用户名
        //String username = (String) principals.getPrimaryPrincipal();

        Session session = SecurityUtils.getSubject().getSession();
        OmUser omUser = (OmUser) session.getAttribute(Constant.USER_SESSION_KEY);

        // 权限信息对象，用来存放查出的用户的所有的角色（role）及权限（permission）等
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (null != omUser) {
            authorizationInfo.setRoles(this.getUserRoles(omUser.getUserId()));
            authorizationInfo.setStringPermissions(this.getUserPermissions(omUser.getUserId()));
        }

        return authorizationInfo;
    }

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    private Set<String> getUserPermissions(Integer userId) {
        List<OmPermis> permisList = permisService.selectByUserId(userId);
        Set<String> stringPermissions = new HashSet<>();
        if (CollectionUtils.isEmpty(permisList)) {
            return stringPermissions;
        }

        for (OmPermis op : permisList) {
            stringPermissions.add(op.getPermisCode());
        }

        return stringPermissions;
    }

    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    private Set<String> getUserRoles(Integer userId) {
        List<OmRole> orRoleList = roleService.selectByUserId(userId);

        Set<String> roles = new HashSet<>();
        if (CollectionUtils.isEmpty(orRoleList)) {
            return roles;
        }

        for (OmRole or : orRoleList) {
            roles.add(or.getRoleCode());
        }

        return roles;
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
