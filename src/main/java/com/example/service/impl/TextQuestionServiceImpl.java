package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TextQuestion;
import com.example.mapper.TextQuestionMapper;
import com.example.service.TextQuestionService;
import com.example.vo.QuestionPaper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TextQuestionServiceImpl
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/14 19:05
 * @Version: 1.0
 **/
@Service
public class TextQuestionServiceImpl implements TextQuestionService {
    @Autowired
    private TextQuestionMapper textQuestionMapper;

    @Override
    public int add(TextQuestion textQuestion) {
        return textQuestionMapper.add(textQuestion);
    }

    @Override
    public TextQuestion findTextQuestionById(Integer questionId) {
        return textQuestionMapper.findTextQuestionById(questionId);
    }

    @Override
    public int update(TextQuestion textQuestion) {
        return textQuestionMapper.update(textQuestion);
    }

    @Override
    public int deleteById(Integer questionId) {
        return textQuestionMapper.deleteById(questionId);
    }

    @Override
    public List<TextQuestion> findByIdAndType(Integer paperId) {
        return textQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId) {
        return textQuestionMapper.findQuestionPaper(questionPage,paperId);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer level, Integer textNumber) {
        System.out.println("texts"+textNumber);
        return textQuestionMapper.findBySubject(subject,level,textNumber);
    }

    @Override
    public List<Integer> findByChapter(String section, Integer level) {
        return textQuestionMapper.findByChapter(section,level);
    }

    @Override
    public List<TextQuestion> findChapterByIdAndType(Integer paperId) {
        return textQuestionMapper.findChapterByIdAndType(paperId);
    }
}
