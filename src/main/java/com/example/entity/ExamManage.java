package com.example.entity;

import lombok.Data;

@Data
public class ExamManage {
    private Integer examCode;

    private String description;

    private String source;

    private Integer paperId;

    private String examDate;

    private Integer totalTime;

    private String grade;

    private String term;

    private String major;

    private String institute;

    // private Integer totalScore;
    private Integer multiScore;

    private Integer fillScore;

    private Integer judgeScore;

    private Integer textScore;

    private Integer calculationScore;

    private String type;

    private String tips;
}