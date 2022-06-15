package com.example.controller;

import com.example.domain.Course;
import com.example.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Course查询接口",tags = "老师和学生和教务的课程查询，选课用的，不包含成绩的")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     *
     * @param name
     * @param type
     * @param teacher_name
     * @param semester
     * @return
     */
    @ApiOperation(value = "通过三个参数")
    @RequestMapping(value ="/queryCourseList")
    public List<Course> queryCourseList(String name,String type,String teacher_name,String semester ){
        return courseService.queryCourseList(name,type,teacher_name,semester);
    }
}
