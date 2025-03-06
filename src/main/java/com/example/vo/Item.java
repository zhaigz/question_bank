package com.example.vo;

import lombok.Data;

//题目模型
@Data
public class Item {
    private Integer difficultyValue;

    private String subject;

    private Integer paperId;

    private Integer changeNumber;

    private Integer fillNumber;

    private Integer judgeNumber;

    private Integer textNumber;

    private Integer calculationNumber;
}
