package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.FillQuestion;
import com.example.mapper.FillQuestionMapper;
import com.example.service.FillQuestionService;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillQuestionServiceImpl implements FillQuestionService {

    @Autowired
    private FillQuestionMapper fillQuestionMapper;

    @Override
    public FillQuestion findFillQuestionById(Integer questionId) {
        return fillQuestionMapper.findFillQuestionById(questionId);
    }

    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<FillQuestion> findAll(Page<FillQuestion> page) {
        return fillQuestionMapper.findAll(page);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(FillQuestion fillQuestion) {
        return fillQuestionMapper.add(fillQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject,Integer level, Integer fillNumber) {
        return fillQuestionMapper.findBySubject(subject,level,fillNumber);
    }

    @Override
    public int update(FillQuestion fillQuestion) {
        return fillQuestionMapper.update(fillQuestion);
    }

    @Override
    public int deleteById(Integer questionId) {
        return fillQuestionMapper.deleteById(questionId);
    }

    @Override
    public IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage,Integer paperId) {
        return fillQuestionMapper.findQuestionPaper(questionPage,paperId);
    }

    @Override
    public List<Integer> findByChapter(String section, Integer level) {
        return fillQuestionMapper.findByChapter(section,level);
    }

    @Override
    public List<FillQuestion> findChapterByIdAndType(Integer paperId) {
        return fillQuestionMapper.findChapterByIdAndType(paperId);
    }

}
