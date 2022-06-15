package com.example.service;

import com.example.domain.Course;
import com.example.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImp implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> queryCourseList(String name,String type,String teacher_name,String semester_id) {
        return courseMapper.queryCourseList(name,type,teacher_name,semester_id);
    }

    @Override
    public int insertCourse(int id, String name, String type, String grade, int teacher_id, String department_id, int semester_id) {
        return courseMapper.insertCourse(id, name, type, grade, teacher_id, department_id, semester_id);
    }
}
