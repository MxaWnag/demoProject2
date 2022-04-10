package com.example.service;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper  userMapper;
    @Override
    public User loginPage(String account,String password) {
        return userMapper.loginPage(account,password);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public int insertUser(String account, String password) {
        return userMapper.insertUser(account,password);

    }
}
