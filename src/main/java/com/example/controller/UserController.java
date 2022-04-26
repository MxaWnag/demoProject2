package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST,RequestMethod.GET})
    public Object loginhttp(@RequestParam(value ="username") String username,
                        @RequestParam(value = "password") String password){
        Subject subject = SecurityUtils.getSubject();
        try{
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            subject.login(usernamePasswordToken);
            System.out.println("登陆成功");
            return "Success";
        }catch(Exception e ){
            e.printStackTrace();
            System.out.println("登陆失败");
            return "False";
        }
    }
    @RequestMapping(value =  "/index")
    public String index(){
        System.out.println("欢迎来到主页");
        return "index";
    }

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userService.queryUserList();
        for (User user :
                userList) {
            System.out.println(user);

        }return userList;
    }
    @RequestMapping(value = "/insertUser",params ={"account","password"} )
    //此方法传的是URL
    public void insertUser(String account,String password ){
        userService.insertUser(account,password);

    }@RequestMapping("/login")//整合shiro框架的登录判定，建议用这个
    public String login(String username, String password ,Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明ok了
            System.out.println("首页");
            return "shouye";//表示首页
        } catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg", "用户名错误");
            //返回显示内容我都帮你写好了，

            return "login";//表示登录页面
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "Incorrect";

        }

    }

}
