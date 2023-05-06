package com.example.mapper;

import com.example.domain.CourseInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseInformationMapper {
    List<CourseInformation> queryCourseInformationList();
    int updateCourseInformation(int Course_id,int Teacher_id,String Course_url,String Course_decs,String Course_img);
}

