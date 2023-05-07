package com.example.demoproject2;
import com.example.controller.UserController;
import com.example.domain.Course;
import com.example.domain.CourseInformation;
import com.example.domain.Enroll;
import com.example.domain.Student;
import com.example.mapper.CourseInformationMapper;
import com.example.mapper.UserInformationMapper;
import com.example.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    
    @Autowired
    CourseServiceImp courseServiceImp;
    @Autowired
    EnrollServiceImp enrollServiceImp;
    @Autowired
    CourseInformationMapper courseInformationMapper;
    @Autowired
    UserInformationMapper userInformationMapper;
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
        map.put("gender","男");
        map.put("grade","大三");
        map.put("major","计算机");
        map.put("campus","闵行");
        map.put("department_id","软件工程");
       int i= studentService.updateStudentInformation(map);
       System.out.println(i);
    }
    @Test
    void Test1(){
        List<Student> L = studentService.queryStudentList();
        for (Student s :
                L) {
            System.out.println(s);
        }
    }
    @Test
    void Test3(){
    List<Course> queryCourse = courseServiceImp.queryCourseList("云计算","专业必修","王廷","2019年上半学期");
        for (Course c :
                queryCourse) {
            System.out.println(c);
        }
    }
    @Test
    void Test4(){
        List<Enroll> queryEnrollList = enrollServiceImp.queryEnrollList("10190448");
        for (Enroll e :
                queryEnrollList) {
            System.out.println(e);
        }

    }
    @Test
    void Test5(){
        enrollServiceImp.insertEnroll(112,"大三",10190448);
    }@Test
    void Test6(){
        enrollServiceImp.deleteEnroll(112);
    }
    @Test
    void Test7(){
        courseServiceImp.insertCourse(113,"离散数学","专业必修","大三",5101,"1",2019);
    }
    @Test
    void Test8(){
        List<Enroll> queryClassEnrollList = enrollServiceImp.queryClassEnrollList(112,5101);
        for (Enroll e :
                queryClassEnrollList) {
            System.out.println(e);
        }
    }
    @Test
    void Test9(){
        List<CourseInformation> queryCourseInformationList = courseInformationMapper.queryCourseInformationList();
        for(CourseInformation C:
            queryCourseInformationList
        ){
            System.out.println(C);
        }
    }
    @Test
    void Test10(){
        courseInformationMapper.updateCourseInformation(1,10000000,"111/11","描述测试","img测试");
    }
    @Test
    void Test11(){
        courseInformationMapper.insertCourseInformation(11,"JoyChen666",10000000,"Course_test2","decs_test2","imgTest2");
    }
    @Test
    void Test12(){
        courseInformationMapper.deleteCourse(1);
    }

    @Test
    void Test13(){
        System.out.print(userInformationMapper.deleteUserInformation(20010709));
    }
}

