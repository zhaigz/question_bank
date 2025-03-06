package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: QuestionPaper
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/10 17:33
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
//题目和试卷左连接查询
public class QuestionPaper {
    private Integer questionId;
    private String question;
    private String section;
    private String level;
    private String type;
    private Integer paperId;
}
