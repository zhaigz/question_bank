package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TextQuestion;
import com.example.vo.QuestionPaper;

import java.util.List;

public interface TextQuestionService {
    int add(TextQuestion textQuestion);

    TextQuestion findTextQuestionById(Integer questionId);

    int update(TextQuestion textQuestion);

    int deleteById(Integer questionId);

    List<TextQuestion> findByIdAndType(Integer paperId);

    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId);

    List<Integer> findBySubject(String subject, Integer level, Integer textNumber);

    List<Integer> findByChapter(String section, Integer level);

    List<TextQuestion> findChapterByIdAndType(Integer paperId);
}
