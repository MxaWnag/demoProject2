package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST,RequestMethod.GET})
    public Object login(HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        //此方法通过传表的方式将数据传来
        String account = request.getParameter("Account");
        String password = request.getParameter("password");
       User tname = userService.loginPage(account,password);
        if(tname ==null){//数据库中没有用户账号，登录失败
            mav.clear();
          //  return new ModelAndView("/loginPage","message",message);这是对接返回页面用的
            return "success";
        }else{
           // return new ModelAndView("/loginPage","message",message);这是对接返回页面用的
            return "false";
        }

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

    }

}
