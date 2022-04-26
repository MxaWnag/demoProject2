package com.example.demoproject2;
import com.example.controller.AdminController;
import com.example.controller.UserController;
import com.example.domain.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.swing.plaf.basic.BasicLabelUI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoProject2ApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserController userController;
    @Autowired
    StudentServiceImpl studentService;

    @Test
    void contextLoads(){

       Student student = studentService.showStudentInformation("10190448");
       System.out.println(student);
    }@Test
    void insertUser(){
        userService.insertUser("root","123456");
    }
    @Test
    void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","10190448");
        map.put("name","桂敏");
        map.put("gender","女");
        map.put("grade","大三");
        map.put("major","计算机");
        map.put("campus","闵行");
        map.put("department_id","软件工程");
       int i= studentService.updateStudentInformation(map);
       System.out.println(i);
    }

}
