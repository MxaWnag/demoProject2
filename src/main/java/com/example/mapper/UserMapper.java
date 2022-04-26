package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User loginPage(String account,String password );
    int  insertUser(String account,String password);
    List<User>queryUserList();
    User queryUserByName(String name);

}
