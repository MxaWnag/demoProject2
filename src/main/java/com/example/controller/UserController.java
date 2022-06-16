package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther Max Wang
 */
@RestController
@Api(value = "User登录接口",tags = "用来登录的")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "跳转至首页")
    @RequestMapping(value =  "/index")
    public String index(){
        System.out.println("欢迎来到主页");
        return "index";
    }

    @ApiOperation(value = "展示用户账号",tags = "展示当前登录的用户,用于登录2")
    @RequestMapping(value ="/showNowUser")
    public Map<String,Object>  showNowUser(){
        Map<String,Object> o = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        User userinfo = (User) subject.getPrincipal();
        System.out.println(userinfo + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        o.put("role",userinfo.getAccount());
        return o;
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "查询并展示所有User")
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userService.queryUserList();
        for (User user :
                userList) {
            System.out.println(user);

        }return userList;
    }
    @ApiOperation(value ="插入一个用户",tags = "一般用不到这个，别用会出事")
    @RequestMapping(value = "/insertUser",params ={"account","password"} )
    //此方法传的是URL
    public Map<String,Object> insertUser(String account,String password ){
        userService.insertUser(account,password);
        Map<String,Object> o = new HashMap<>();
        o.put("code",0);
        return o;

    }

    /**
     *
     * @param username
     * @param password
     * @param model
     * @return
     */
    @ApiOperation(value = "登录方法",tags = "登录就用这个")
    @RequestMapping("/login")//整合shiro框架的登录判定，建议用这个
    public Map<String,Object> login(String username, String password , Model model) {
        Map<String,Object> o = new HashMap<>();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明ok了
            if(userService.isTeacher(username)){
                o.put("code",0);
                o.put("role","teacher");
                return o;
            }else if(userService.isAdmin(username))
            {
                o.put("code",0);
                o.put("role","user");
                return o;
            }else if(userService.isStudent(username)){
                o.put("code",0);
                o.put("role","student");
                return o;
            }else{
                o.put("code",-1);
                o.put("role","weizhi");
                return o;
            }


        } catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg", "用户名错误");
            //返回显示内容我都帮你写好
            o.put("code",-1);
            o.put("role",null);
            return o;
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            o.put("code",-1);
            o.put("role",null);
            return o;
        }

    }
    @ApiOperation(value = "登出方法",tags = "登出用这个")
    @RequestMapping("/logout")
    public Map<String,Object> logout(){
        Map<String,Object>o = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        o.put("code",0);
        return o;
    }
}
