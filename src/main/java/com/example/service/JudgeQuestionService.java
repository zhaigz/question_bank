package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.JudgeQuestion;
import com.example.vo.QuestionPaper;

import java.util.List;

public interface JudgeQuestionService {

    List<JudgeQuestion> findByIdAndType(Integer paperId);

    IPage<JudgeQuestion> findAll(Page<JudgeQuestion> page);

    JudgeQuestion findOnlyQuestionId();

    int add(JudgeQuestion judgeQuestion);

    List<Integer> findBySubject(String subject,Integer level,Integer judgeNumber);

    JudgeQuestion findJudgeQuestionById(Integer questionId);

    int update(JudgeQuestion judgeQuestion);

    int deleteById(Integer questionId);

    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage,Integer paperId);

    List<Integer> findByChapter(String section, Integer level);

    List<JudgeQuestion> findChapterByIdAndType(Integer paperId);
}
