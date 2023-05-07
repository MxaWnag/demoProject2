package com.example.mapper;

import com.example.domain.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInformationMapper {
    List<UserInformation> queryUserInformationList();
    int updateUserInformation(int User_id,String User_name,String User_pwd,String User_img,String User_char);
    int insertUserInformation(int User_id,String User_name,String User_pwd,String User_img,String User_char);

    int deleteUserInformation(int User_id);
}

