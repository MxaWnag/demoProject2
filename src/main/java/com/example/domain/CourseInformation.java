package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInformation {
    private int Course_id;

    private String Course_name;

    private String Course_decs;
    private String Course_url;
    private String Course_img;
    private String Teacher_id;
}
