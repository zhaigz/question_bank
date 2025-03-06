package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.CalculationQuestion;
import com.example.mapper.CalculationQuestionMapper;
import com.example.service.CalculationQuestionService;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CalculationQuestionServiceImpl
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/15 9:07
 * @Version: 1.0
 **/
@Service
public class CalculationQuestionServiceImpl implements CalculationQuestionService {
    @Autowired
    private CalculationQuestionMapper calculationQuestionMapper;


    @Override
    public int add(CalculationQuestion calculationQuestion) {
        return calculationQuestionMapper.add(calculationQuestion);
    }

    @Override
    public int update(CalculationQuestion calculationQuestion) {
        return calculationQuestionMapper.update(calculationQuestion);
    }

    @Override
    public IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId) {
        return calculationQuestionMapper.findQuestionPaper(questionPage,paperId);
    }

    @Override
    public CalculationQuestion findCalculationQuestionById(Integer questionId) {
        return calculationQuestionMapper.findCalculationQuestionById(questionId);
    }

    @Override
    public int deleteById(Integer questionId) {
        return calculationQuestionMapper.deleteById(questionId);
    }

    @Override
    public List<CalculationQuestion> findByIdAndType(Integer paperId) {
        return calculationQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer level, Integer calculationNumber) {
        return calculationQuestionMapper.findBySubject(subject,level,calculationNumber);
    }

    @Override
    public List<Integer> findByChapter(String section, Integer level) {
        return calculationQuestionMapper.findByChapter(section,level);
    }

    @Override
    public List<CalculationQuestion> findChapterByIdAndType(Integer paperId) {
        return calculationQuestionMapper.findChapterByIdAndType(paperId);
    }
}
