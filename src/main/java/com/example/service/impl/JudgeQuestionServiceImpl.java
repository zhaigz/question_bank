package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.JudgeQuestion;
import com.example.mapper.JudgeQuestionMapper;
import com.example.service.JudgeQuestionService;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {

    @Autowired
    private JudgeQuestionMapper judgeQuestionMapper;

    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<JudgeQuestion> findAll(Page<JudgeQuestion> page) {
        return judgeQuestionMapper.findAll(page);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.add(judgeQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject,Integer level, Integer judgeNumber) {
        return judgeQuestionMapper.findBySubject(subject,level,judgeNumber);
    }

    @Override
    public JudgeQuestion findJudgeQuestionById(Integer questionId) {
        return judgeQuestionMapper.findJudgeQuestionById(questionId);
    }

    @Override
    public int update(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.update(judgeQuestion);
    }

    @Override
    public int deleteById(Integer questionId) {
        return judgeQuestionMapper.deleteById(questionId);
    }

    @Override
    public IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage,Integer paperId) {
        return judgeQuestionMapper.findQuestionPaper(questionPage,paperId);
    }

    @Override
    public List<Integer> findByChapter(String section, Integer level) {
        return judgeQuestionMapper.findByChapter(section,level);
    }

    @Override
    public List<JudgeQuestion> findChapterByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findChapterByIdAndType(paperId);
    }
}
