package com.example.controller;

import com.example.domain.Enroll;
import com.example.domain.Student;
import com.example.service.EnrollService;
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
    @Autowired
    private EnrollService enrollService;
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
    @ApiOperation(value ="查询学生成绩",tags = "需要提供一个Student的id,需要已经登录才行")
    @RequestMapping(value = "/queryEnrollList")
    public List<Enroll> queryEnrollList(){
        Student s =  studentService.showStudentInformation(SecurityUtils.getSubject().getPrincipals().toString());
        return enrollService.queryEnrollList(s.getId());
    }

    /**
     *
     * @param course_id
     * @param grade
     * @param student_id
     * 点击选课后将用三个参数添加课程,用显示出来的表中的数据就行了
     */
    @ApiOperation(value ="插入课程",tags = "学生选课用的")
    @RequestMapping(value ="/insertEnroll")
    public Map<String,Object> insertEnroll(int course_id,String grade,int student_id){
        enrollService.insertEnroll(course_id,grade,student_id);
        Map<String,Object> o = new HashMap<>();
        o.put("msg","插入成功学号为"+student_id);
        return o;
    }
    @ApiOperation(value = "删除课程",tags = "退课用的")
    @RequestMapping(value ="/deleteEnroll")
    public Map<String,Object> deleteEnroll(int course_id){
            enrollService.deleteEnroll(course_id);
            Map<String,Object>o = new HashMap<>();
            o.put("msg","退课成功"+course_id);
            return o;
    }


}
