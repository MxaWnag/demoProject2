package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    private int User_id;
    private String User_name;
    private String User_pwd;
    private String User_img;
    private String User_char;

}
