package com.example.mapper;

import com.example.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    List<Course> queryCourseList();
}
