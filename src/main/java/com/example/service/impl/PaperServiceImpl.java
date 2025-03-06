package com.example.service.impl;

import com.example.entity.PaperChapter;
import com.example.entity.PaperManage;
import com.example.mapper.PaperMapper;
import com.example.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;
    @Override
    public List<PaperManage> findAll() {
        return paperMapper.findAll();
    }

    @Override
    public List<PaperManage> findById(Integer paperId) {
        return paperMapper.findById(paperId);
    }

    @Override
    public int add(PaperManage paperManage) {
        return paperMapper.add(paperManage);
    }

    @Override
    public int delete(Integer paperId, Integer questionId) {
        return paperMapper.delete(paperId,questionId);
    }

    @Override
    public int addChapterTest(PaperChapter paperChapter) {
        return paperMapper.addChapterTest(paperChapter);
    }

}
