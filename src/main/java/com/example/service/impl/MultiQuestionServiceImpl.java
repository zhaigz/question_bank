package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MultiQuestion;
import com.example.mapper.MultiQuestionMapper;
import com.example.service.MultiQuestionService;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {

    @Autowired
    private MultiQuestionMapper multiQuestionMapper;

    @Override
    public MultiQuestion findMultiQuestionById(Integer questionId) {
        return multiQuestionMapper.findMultiQuestionById(questionId);
    }

    @Override
    public List<MultiQuestion> findByIdAndType(Integer PaperId) {
        return multiQuestionMapper.findByIdAndType(PaperId);
    }


    @Override
    public IPage<MultiQuestion> findAll(Page<MultiQuestion> page) {
        return multiQuestionMapper.findAll(page);
    }

    @Override
    public IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> page,Integer paperId) {
        return multiQuestionMapper.findQuestionPaper(page,paperId);
    }

    @Override
    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(MultiQuestion multiQuestion) {
        return multiQuestionMapper.add(multiQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject,Integer level, Integer changeNumber) {
        return multiQuestionMapper.findBySubject(subject,level,changeNumber);
    }

    @Override
    public int update(MultiQuestion multiQuestion) {
        return multiQuestionMapper.update(multiQuestion);
    }

    @Override
    public int deleteById(Integer questionId) {
        return multiQuestionMapper.deleteById(questionId);
    }

    @Override
    public List<Integer> findByChapter(String section, Integer level) {
        return multiQuestionMapper.findByChapter(section,level);
    }

    @Override
    public List<MultiQuestion> findChapterByIdAndType(Integer paperId) {
        return multiQuestionMapper.findChapterByIdAndType(paperId);
    }


}
