package com.example.demoproject2;
import com.example.controller.AdminController;
import com.example.controller.UserController;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoProject2ApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserController userController;

    @Test
    void contextLoads(){
        System.out.println(userService.queryUserByName("root"));
    }@Test
    void insertUser(){
        userService.insertUser("root","123456");
    }
    @Test
    void test(){

    }

}
