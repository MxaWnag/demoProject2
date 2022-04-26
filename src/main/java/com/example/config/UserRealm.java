package com.example.config;

import com.example.domain.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权doGetAuthorizationInfo");
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名，密码，数据库取
        System.out.println("执行了认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user =userService.queryUserByName(userToken.getUsername());
        if(user ==null){
            //
            return null; //抛出异常 UnknownAccountException
        }//密码认证
        return new SimpleAuthenticationInfo("",user.getPassword(),"");

    }
}
