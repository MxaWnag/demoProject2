package com.example.mapper;

import com.example.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> queryStudentList();
    Student showStudentInformation(String id);
    int updateStudentInformation(Map<String,Object> params);


}
