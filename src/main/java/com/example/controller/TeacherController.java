package com.example.controller;

import com.example.domain.Enroll;
import com.example.service.CourseService;
import com.example.service.EnrollService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教师的查询课程用CourseController里面的queryCourseList,
 */
@RestController
@Api(value = "教师的查询接口")
public class TeacherController {
    @Autowired
    private CourseService courseService;
    private EnrollService enrollService;
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
    public Map<String,Object> insertCourse(int id,String name,String type,String grade,int teacher_id,String department_id,int semester_id){
        Map<String,Object>o = new HashMap<>();
        courseService.insertCourse(id,name,type,grade,teacher_id,department_id,semester_id);
        o.put("msg","申请成功"+id);
        return o;
    }

    /**
     *
     * @param course_id
     * @param teacher_id
     * @return
     */
    @ApiOperation(value = "查询某教师某课程学生列表")
    @RequestMapping(value = "/queryClassEnrollList")
    public List<Enroll> queryClassEnrollList(int course_id, int teacher_id){
        return enrollService.queryClassEnrollList(course_id,teacher_id);
    }

    /**
     *
     * @param student_id
     * @param score
     */
    @ApiOperation(value = "登记成绩")
    @RequestMapping(value = "/updateScore")
    public Map<String,Object> updateScore(int student_id, float score){
        enrollService.updateScore(student_id,score);
        Map<String,Object> o = new HashMap<>();
        o.put("code",0);
        return o;
    }


}
