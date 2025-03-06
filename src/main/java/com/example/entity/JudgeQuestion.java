package com.example.entity;

import lombok.Data;

//判断题实体类
@Data
public class JudgeQuestion {
    private Integer questionId;

    private String subject;

    private String question;

    private String rightAnswer;

    private String level;

    private String section;

    private Integer score;

    private String analysis; //题目解析

    private String type;
}