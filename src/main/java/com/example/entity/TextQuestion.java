package com.example.entity;

import lombok.Data;

//填空题实体类
@Data
public class TextQuestion {
    private Integer questionId;

    private String subject;

    private String question;

    private String rightAnswer;

    private Integer score;

    private String level;

    private String section;

    private String analysis; //题目解析

    private String type;
}
