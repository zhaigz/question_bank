package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.CalculationQuestion;
import com.example.entity.TextQuestion;
import com.example.vo.QuestionPaper;

import java.util.List;

public interface CalculationQuestionService {
    int add(CalculationQuestion calculationQuestion);

    int update(CalculationQuestion calculationQuestion);

    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId);

    CalculationQuestion findCalculationQuestionById(Integer questionId);

    int deleteById(Integer questionId);

    List<CalculationQuestion> findByIdAndType(Integer paperId);

    List<Integer> findBySubject(String subject, Integer level, Integer calculationNumber);

    List<Integer> findByChapter(String section, Integer level);

    List<CalculationQuestion> findChapterByIdAndType(Integer paperId);
}
