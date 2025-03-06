package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.FillQuestion;
import com.example.entity.MultiQuestion;
import com.example.vo.QuestionPaper;

import java.util.List;

public interface FillQuestionService {

    FillQuestion findFillQuestionById(Integer questionId);

    List<FillQuestion> findByIdAndType(Integer paperId);

    IPage<FillQuestion> findAll(Page<FillQuestion> page);

    FillQuestion findOnlyQuestionId();

    int add(FillQuestion fillQuestion);

    List<Integer> findBySubject(String subject,Integer level,Integer fillNumber);


    int update(FillQuestion fillQuestion);

    int deleteById(Integer questionId);

    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage,Integer paperId);

    List<Integer> findByChapter(String section, Integer level);

    List<FillQuestion> findChapterByIdAndType(Integer paperId);
}
