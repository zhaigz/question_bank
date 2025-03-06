package com.example.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private String institute;

    private String sex;

    private String tel;

    private String pwd;

    private String type;

    private String role;
}