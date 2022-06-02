package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String gender;
    private String grade;
    private String major;
    private String campus;
    private String department_id;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", campus='" + campus + '\'' +
                ", department_id='" + department_id + '\'' +
                '}';
    }
}
