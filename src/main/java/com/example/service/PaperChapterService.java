package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.ExamManage;
import com.example.entity.PaperChapter;
import com.example.vo.QuestionPaper;

import java.awt.print.Paper;
import java.util.List;

public interface PaperChapterService {
    IPage<PaperChapter> findByStudentId(Page<PaperChapter> page, Integer studentId);
    PaperChapter findOnlyPaperId();
    PaperChapter findPaperById(Integer paperId);

    List<PaperChapter> findAllByStudentId(Integer studentId);

    int deleteById(Integer paperId);
}
