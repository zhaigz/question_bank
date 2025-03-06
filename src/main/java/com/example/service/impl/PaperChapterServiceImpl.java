package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.PaperChapter;
import com.example.mapper.PaperChapterMapper;
import com.example.service.PaperChapterService;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PaperChapterServiceImpl
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/20 12:37
 * @Version: 1.0
 **/
@Service
public class PaperChapterServiceImpl implements PaperChapterService {
    @Autowired
    private PaperChapterMapper paperChapterMapper;

    @Override
    public IPage<PaperChapter> findByStudentId(Page<PaperChapter> page, Integer studentId) {
        return paperChapterMapper.findByStudentId(page,studentId);
    }

    @Override
    public PaperChapter findOnlyPaperId() {
        return paperChapterMapper.findOnlyPaperId();
    }

    @Override
    public PaperChapter findPaperById(Integer paperId) {
        return paperChapterMapper.findPaperById(paperId);
    }

    @Override
    public List<PaperChapter> findAllByStudentId(Integer studentId) {
        return paperChapterMapper.findAllBYStudentId(studentId);
    }

    @Override
    public int deleteById(Integer paperId) {
        return paperChapterMapper.deleteById(paperId);
    }
}
