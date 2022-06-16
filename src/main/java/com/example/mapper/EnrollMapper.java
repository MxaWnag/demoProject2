package com.example.mapper;

import com.example.domain.Enroll;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnrollMapper {
    List<Enroll> queryEnrollList(String student_id);
    int insertEnroll(int course_id,String grade,int student_id);
    int deleteEnroll(int course_id);
    List<Enroll> queryClassEnrollList(int course_id, int teacher_id);
    int updateScore(int student_id, float score);
}
