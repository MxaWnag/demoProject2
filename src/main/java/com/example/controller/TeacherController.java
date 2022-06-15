package com.example.controller;

import com.example.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师的查询课程用CourseController里面的queryCourseList,
 */
@RestController
@Api(value = "教师的查询接口")
public class TeacherController {
    @Autowired
    private CourseService courseService;

    /**
     *
     * @param id
     * @param name
     * @param type
     * @param grade
     * @param teacher_id
     * @param department_id
     * @param semester_id
     */
    @ApiOperation(value = "申请课程",tags = "用于申请课程，得在登录后使用")
    @RequestMapping(value ="/insertCourse")
    public String insertCourse(int id,String name,String type,String grade,int teacher_id,String department_id,int semester_id){

        courseService.insertCourse(id,name,type,grade,teacher_id,department_id,semester_id);
        return "申请成功"+id;
    }


}
