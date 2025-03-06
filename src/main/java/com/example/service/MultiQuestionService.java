package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MultiQuestion;
import com.example.vo.AnswerVO;
import com.example.vo.QuestionPaper;

import java.util.List;

public interface MultiQuestionService {

    MultiQuestion findMultiQuestionById(Integer questionId);

    List<MultiQuestion> findByIdAndType(Integer PaperId);

    IPage<MultiQuestion> findAll(Page<MultiQuestion> page);

    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> page,Integer paperId);

    MultiQuestion findOnlyQuestionId();

    int add(MultiQuestion multiQuestion);

    List<Integer> findBySubject(String subject,Integer level,Integer changeNumber);

    int update(MultiQuestion multiQuestion);

    int deleteById(Integer questionId);

    List<Integer> findByChapter(String section, Integer level);

    //根据试卷及问题类型查询试题信息
    List<MultiQuestion> findChapterByIdAndType(Integer paperId);
}
