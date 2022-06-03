package com.example.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
        *   anon:无需认证就可以访问
        *   authc：必须认证才能访问
        *   user:必须拥有记住我的功能才能使用；
        *   perms：拥有对某个资源的权限才能访问
        *   role:拥有某个角色权限才能访问
        * */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/x/xx","authc"); //  这个xx页面无需认证就能访问
        //bean.setFilterChainDefinitionMap(filterMap);
       // bean.setLoginUrl("/xxxxxx");
        return bean;
    }
    //DefaultWebSecurityManager:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm ){
         DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
         //关联UserRealm
         securityManager.setRealm(userRealm);
         return securityManager;
    }


    //创建realm对象,需要自0定义类：1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
