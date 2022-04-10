package com.example.mapper;

import com.example.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {


    List<Admin> queryAdminList();

    int addAdmin(String account,String password);
}
