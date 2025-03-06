package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.AnswerMapper;
import com.example.service.AnswerService;
import com.example.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<AnswerVO> findAll() {
        return answerMapper.findAll();
    }

    @Override
    public IPage<AnswerVO> findAll(Page<AnswerVO> page) {
        return answerMapper.findAll(page);
    }
}
