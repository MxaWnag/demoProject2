package com.example.mapper;

import com.example.domain.SystemEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SystemEvaluationMapper {
    List<SystemEvaluation> querySystemEvaluationList();

}
