package com.example.service;

import com.example.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryCourseList(String name,String type,String teacher_name,String semester_id);
    int insertCourse(int id,String name,String type,String grade,int teacher_id,String department_id,int semester_id);
}
