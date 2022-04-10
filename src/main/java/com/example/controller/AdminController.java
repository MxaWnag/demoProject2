package com.example.controller;

import com.example.domain.Admin;
import com.example.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/queryAdminList")
    public List<Admin> queryAdminList(){
        List<Admin> adminList = adminMapper.queryAdminList();
        for (Admin admin :
                adminList) {
            System.out.println(admin);

        }return adminList;
    }
    @GetMapping("/addadmin")
    public void addAdmin(){
        System.out.println("successfully add");

    }
    @GetMapping("/hello")
    public String hello(){
        return "halloworld";
    }

}
