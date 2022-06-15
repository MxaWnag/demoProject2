package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enroll {
    private String course_id;
    private float score;
    private char grade;
    private int student_id;

}
