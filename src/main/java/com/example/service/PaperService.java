package com.example.service;

import com.example.entity.PaperChapter;
import com.example.entity.PaperManage;

import java.util.List;

public interface PaperService {

    List<PaperManage> findAll();

    List<PaperManage> findById(Integer paperId);

    int add(PaperManage paperManage);

    int delete(Integer paperId, Integer questionId);

    int addChapterTest(PaperChapter paperChapter);

}
