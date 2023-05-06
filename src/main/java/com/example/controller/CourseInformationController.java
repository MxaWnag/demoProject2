package com.example.controller;

import com.example.domain.CourseInformation;
import com.example.mapper.CourseInformationMapper;
import com.google.common.annotations.VisibleForTesting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "CourseInformation",tags = "CouseInformation")
public class CourseInformationController {
    @Autowired
    private CourseInformationMapper courseInformationMapper;
    @ApiOperation(value="查询所有课程",tags="无参数")
    @RequestMapping(value="/queryCourseInformationList")
    public List<CourseInformation> queryCourseInformation(){
        return courseInformationMapper.queryCourseInformationList();
    }
    @ApiOperation(value="更新课程",tags="更新，五个参数")
    @RequestMapping(value="/updateCourse")
    public void updateCourse(int Course_id,int Teacher_id,String Course_url,String Course_decs,String Course_img){
        //System.out.println(Course_id);
        System.out.println(courseInformationMapper.updateCourseInformation(Course_id,Teacher_id,Course_url,Course_decs,Course_img));
    }
    @ApiOperation(value="插入课程",tags="插入，六个参数")
    @RequestMapping(value="/insertCourse")
    public void insertCourse(int Course_id,String Course_name,int Teacher_id,String Course_url,String Course_decs,String Course_img){
        System.out.println(courseInformationMapper.insertCourseInformation(Course_id,Course_name,Teacher_id,Course_url,Course_decs,Course_img));
    }
    @ApiOperation(value="删除课程",tags="删除，一个参数")
    @RequestMapping(value="/deleteCourse")
    public void deleteCourse(int Course_id){
       System.out.println(courseInformationMapper.deleteCourse(Course_id));
    }

}
