package com.example.controller;

import com.example.domain.SystemEvaluation;
import com.example.mapper.SystemEvaluationMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "SystemEvaluationController",tags = "SystemEvaluation")
public class SystemEvaluationController {
    @Autowired
    private SystemEvaluationMapper systemEvaluationMapper;
    @ApiOperation(value = "查询所有系统评价")
    @RequestMapping(value = "//querySystemEvaluationList")
    public List<SystemEvaluation> querySystemEvaluation(){
        return systemEvaluationMapper.querySystemEvaluationList();
    }
    @ApiOperation(value="插入教师")
    @RequestMapping(value ="//insertTeacher")
    public void insertSystem(int Evaluate_id,String Course_name,String Stu_name,int Count,String Content,int Course_id,int Stu_id){
        System.out.println(systemEvaluationMapper.insertSystem(Evaluate_id,Course_name,Stu_name,Count,Content,Course_id,Stu_id));
    }
    @ApiOperation(value="删除教师")
    @RequestMapping(value = "//deleteTeacher")
    public void deleteSystem(int Evaluate_id){
        System.out.println(systemEvaluationMapper.deleteSystem(Evaluate_id));
    }
}
