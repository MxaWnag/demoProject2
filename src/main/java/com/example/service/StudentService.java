package com.example.service;

import com.example.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> queryStudentList();
    Student showStudentInformation(String id);
    int updateStudentInformation(Map<String,Object> params);
}
