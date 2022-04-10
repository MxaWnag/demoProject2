package com.example.service;

import com.example.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User  loginPage(String account,String password);
    List<User>queryUserList();
    int insertUser(String account, String password);
}
