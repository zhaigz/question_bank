package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: PaperChapter
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/20 0:16
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperChapter {
    private Integer paperId;

    private String  paperName;

    private String description;

    private String createTime;

    private Integer questionType;

    private Integer questionId;

    private Integer studentId;
}
