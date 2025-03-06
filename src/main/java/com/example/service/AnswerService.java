package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.AnswerVO;

import java.util.List;

public interface AnswerService {

    List<AnswerVO> findAll();

    IPage<AnswerVO> findAll(Page<AnswerVO> page);

}
