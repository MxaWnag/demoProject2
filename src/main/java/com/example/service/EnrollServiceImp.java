package com.example.service;

import com.example.domain.Enroll;
import com.example.mapper.EnrollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnrollServiceImp implements EnrollService{
    @Autowired
    private EnrollMapper enrollMapper;


    @Override
    public List<Enroll> queryEnrollList(String student_id) {
        return enrollMapper.queryEnrollList(student_id);
    }

    @Override
    public int insertEnroll(int course_id, String grade, int student_id) {
        return enrollMapper.insertEnroll(course_id,grade,student_id);
    }

    @Override
    public int deleteEnroll(int course_id) {
        return enrollMapper.deleteEnroll(course_id);
    }

}
