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
    public List<Course> queryCourseList() {
        return courseMapper.queryCourseList();
    }
}
