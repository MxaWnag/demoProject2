package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "Student查询接口",tags = "一系列Student的操作")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value ="查询并展示所有Student")
    @GetMapping(value = "/queryStudentList")
    public List<Student> queryStudentList(){
        return studentService.queryStudentList();
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查询学生信息")
    @RequestMapping(value = "/showStudentInformation",params ={"id"} )
    public Student showStudentInformation(String id){
        Student s =  studentService.showStudentInformation(id);
        System.out.println(s.toString());
        return s;
    }


    @ApiOperation(value = "通过id查询学生信息")
    @RequestMapping(value = "/showNowStudentInformation" )
    public Student showNowStudentInformation(){

        Student s =  studentService.showStudentInformation(SecurityUtils.getSubject().getPrincipals().toString());
        System.out.println(s.toString());
        return s;
    }
    /**
     *
     * @param id
     * @param name
     * @param gender
     * @param grade
     * @param major
     * @param campus
     * @param department_id
     */
    @ApiOperation(value = "更新学生信息",tags = "需要提供一整个Student的信息")
    @RequestMapping(value = "/updateStudentInformation")
    public void updateStudentInformation(String id,String name,String gender,String grade,String major,String campus,String department_id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("gender",gender);
        map.put("grade",grade);
        map.put("major",major);
        map.put("campus",campus);
        map.put("department_id",department_id);
        int i = studentService.updateStudentInformation(map);
        System.out.println(i);
    }


}
