package com.example.mapper;

import com.example.domain.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInformationMapper {
    List<UserInformation> queryUserInformationMapper();
}

