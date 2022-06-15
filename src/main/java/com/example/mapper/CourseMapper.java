package com.example.mapper;

import com.example.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    List<Course> queryCourseList(String name,String type,String teacher_name,String semester_id);
    int insertCourse(int id,String name,String type,String grade,int teacher_id,String department_id,int semester_id);
}
