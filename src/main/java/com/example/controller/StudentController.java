package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
