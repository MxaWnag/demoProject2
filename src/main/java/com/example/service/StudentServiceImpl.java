package com.example.service;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> queryStudentList(){
        return studentMapper.queryStudentList();
    }

    @Override
    public Student showStudentInformation(String id) {
        return studentMapper.showStudentInformation(id);
    }

    @Override
    public int updateStudentInformation(Map<String, Object> params) {
        return studentMapper.updateStudentInformation(params);
    }


}
