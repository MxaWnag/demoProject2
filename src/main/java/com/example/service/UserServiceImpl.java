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

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public boolean isTeacher(String account) {
        if(account.charAt(0)=='5')
            return true;
        else
            return false;
    }

    @Override
    public boolean isStudent(String account) {
        if(account.charAt(0)=='1')
            return true;
        else
            return false;
    }

    @Override
    public boolean isAdmin(String account) {
        if(account.charAt(0)=='0')
            return true;
        else
            return false;
    }
}
