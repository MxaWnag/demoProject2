package com.example.service;

import com.example.domain.Enroll;

import java.util.List;

public interface EnrollService {
    List<Enroll> queryEnrollList(String student_id);
    int insertEnroll(int course_id,String grade,int student_id);
    int deleteEnroll(int course_id);
}
