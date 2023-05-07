package com.example.controller;

import com.example.domain.UserInformation;
import com.example.mapper.UserInformationMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "UserInformation",tags="UserInformation")
public class UserInformationController {
    @Autowired
    private UserInformationMapper userInformationMapper;
    @RequestMapping(value = "/queryUserInformationList")
    public List<UserInformation> queryUserInformation(){
        return userInformationMapper.queryUserInformationList();
    }
    @RequestMapping("/insertUser")
    public void insertUser(int User_id,String User_name,String User_pwd,String User_img,String User_char){
        System.out.println(userInformationMapper.insertUserInformation(User_id,User_name,User_pwd,User_img,User_char));
    }@RequestMapping("/updateUser")
    public void updateUser(int User_id,String User_name,String User_pwd,String User_img,String User_char){
       System.out.println( userInformationMapper.updateUserInformation(User_id,User_name,User_pwd,User_img,User_char));
    }
    @RequestMapping("/deleteUser")
    public void deleteUser(int User_id){
        System.out.println(userInformationMapper.deleteUserInformation(User_id));
    }
}
