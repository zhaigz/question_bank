package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: PaperTest
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/20 9:09
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterTest {
    private String paperName;//自测题名称

    private String description;

    private String[] sections;

    private Integer[] number;

    private Integer difficultyValue;

    private String subject;

    private Integer paperId;

    private Integer userId;

    private String createTime;

}
