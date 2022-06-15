package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 教务的学生信息管理可用StudentController里面的queryStudentList和updateStudentInformation
 */
@RestController
public class ManagerController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询并展示所有User",tags = "教务用于用户管理")
    @GetMapping("/queryAllUser")
    public List<User> queryUserList(){
        List<User> userList = userService.queryUserList();
        for (User user :
                userList) {
            System.out.println(user);

        }return userList;
    }

}
