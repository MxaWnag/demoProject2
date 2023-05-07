package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEvaluation {
    private int Evaluate_id;
    private String Course_name;
    private String Stu_name;
    private String State;
    private String Content;
    private int Teacher_id;
    private int Stu_id;

}
