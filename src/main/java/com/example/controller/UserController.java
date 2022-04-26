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

import java.util.List;

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
    public void insertUser(String account,String password ){
        userService.insertUser(account,password);

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
    public String login(String username, String password ,Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明ok了
            if(userService.isTeacher(username)){
                return "jiaoshishouye";
            }else if(userService.isAdmin(username))
            {
                return "guanliyuanshouye";
            }else if(userService.isStudent(username)){
                return "xueshengshouye";
            }else return "weizhidezhanghaoleixing";


        } catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg", "用户名错误");
            //返回显示内容我都帮你写好了

            return "login";//表示登录页面
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "Incorrect";//表示错误页面

        }

    }

}
