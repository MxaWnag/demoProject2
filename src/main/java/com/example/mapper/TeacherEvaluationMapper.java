package com.example.mapper;

import com.example.domain.TeacherEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherEvaluationMapper {
    List<TeacherEvaluation> queryTeacherEvaluation();
}
