package com.example.controller;

import com.example.domain.CourseInformation;
import com.example.mapper.CourseInformationMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "CourseInformation",tags = "查询CouseInformation")
public class CourseInformationController {
    @Autowired
    private CourseInformationMapper courseInformationMapper;
    @RequestMapping(value="/queryCourseInformationList")
    public List<CourseInformation> queryCourseInformation(){
        return courseInformationMapper.queryCourseInformationList();
    }
    @RequestMapping(value="/updateCourse")
    public void updateCourse(int Course_id,int Teacher_id,String Course_url,String Course_decs,String Course_img){
        //System.out.println(Course_id);
        System.out.println(courseInformationMapper.updateCourseInformation(Course_id,Teacher_id,Course_url,Course_decs,Course_img));
    }
}
