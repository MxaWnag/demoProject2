package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemEvaluation {
    private int evaluate_id;
    private String Course_name;
    private String Stu_name;
    private int count;
    private String Content;
    private String Course_id;
    private String Stu_id;


}
