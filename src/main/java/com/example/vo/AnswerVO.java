package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerVO {
    private Integer questionId;
    private String question;
    private String subject;
    private String score;
    private String section;
    private String level;
    private String type;
}
