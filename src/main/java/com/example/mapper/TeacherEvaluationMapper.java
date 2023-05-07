package com.example.mapper;

import com.example.domain.TeacherEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherEvaluationMapper {
    List<TeacherEvaluation> queryTeacherEvaluationList();
    int insertTeacher(int Evaluate_id,String Course_name,String Stu_name,String State,String Content,int Teacher_id,int Stu_id);

    int updateTeacher(int Evaluate_id,String State,String Content);

    int deleteTeacher(int Evaluate_id);
}
