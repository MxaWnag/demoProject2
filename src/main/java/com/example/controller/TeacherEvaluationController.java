package com.example.controller;

import com.example.domain.TeacherEvaluation;
import com.example.mapper.TeacherEvaluationMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "TeacherEvaluation",tags = "TeacherEvaluation")
public class TeacherEvaluationController {
    @Autowired
    private TeacherEvaluationMapper teacherEvaluationMapper;
    @RequestMapping(value = "/queryTeacherEvaluationList")
    public List<TeacherEvaluation> queryTeacherEvaluationList(){
        return teacherEvaluationMapper.queryTeacherEvaluationList();
    }
    @RequestMapping(value = "/insertTeacher")
    public void insertTeacher(int Evaluate_id,String Course_name,String Stu_name,String State,String Content,int Teacher_id,int Stu_id){
        System.out.println(teacherEvaluationMapper.insertTeacher(Evaluate_id,Course_name,Stu_name,State,Content,Teacher_id,Stu_id));
    }
    @RequestMapping(value = "/updateTeacher")
    public void updateTeacher(int Evaluate_id,String State,String Content){
        System.out.println(teacherEvaluationMapper.updateTeacher(Evaluate_id,State,Content));
    }
    @RequestMapping(value = "/deleteTeacher")
    public void deleteTeacher(int Evaluate_id){
        System.out.println(teacherEvaluationMapper.deleteTeacher(Evaluate_id));
    }
}
