package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.*;
import com.example.service.impl.*;
import com.example.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PaperChapter
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/20 12:35
 * @Version: 1.0
 **/
@RestController
public class PaperChapterController {
    @Autowired
    PaperChapterServiceImpl paperChapterService;
    @Autowired
    MultiQuestionServiceImpl multiQuestionService;
    @Autowired
    FillQuestionServiceImpl fillQuestionService;
    @Autowired
    JudgeQuestionServiceImpl judgeQuestionService;
    @Autowired
    TextQuestionServiceImpl textQuestionService;
    @Autowired
    CalculationQuestionServiceImpl calculationQuestionService;

    //不分页查询学生的所有章节自测
    @GetMapping("/chapterTests/{studentId}")
    public ApiResult findAllChapterTest(@PathVariable("studentId") Integer studentId){
        List<PaperChapter> paperChapters = paperChapterService.findAllByStudentId(studentId);
        return  ApiResultHandler.buildApiResult(200, "请求成功！", paperChapters);
    }

    //分页查询学生的所有章节自测
    @GetMapping("/chapterTest/{page}/{size}/{studentId}")
    public ApiResult findByStudentId(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@PathVariable("studentId") Integer studentId){
        ApiResult apiResult;
        Page<PaperChapter> paperChapterPage = new Page<>(page,size);
        IPage<PaperChapter> all = paperChapterService.findByStudentId(paperChapterPage,studentId);
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", all);
        return apiResult;
    }
    //根据试卷编号查询所有题型，组成试卷返回
    @GetMapping("/paperChapter/{paperId}")
    public Map<String, Object> findById(@PathVariable("paperId") Integer paperId) {
        List<MultiQuestion> multiQuestionRes = multiQuestionService.findChapterByIdAndType(paperId);   //选择题题库 1
        List<FillQuestion> fillQuestionRes = fillQuestionService.findChapterByIdAndType(paperId);     //填空题题库 2
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findChapterByIdAndType(paperId);   //判断题题库 3
        List<TextQuestion> textQuestionRes = textQuestionService.findChapterByIdAndType(paperId);     //简答题题库 4
        List<CalculationQuestion> calculationQuestionRes = calculationQuestionService.findChapterByIdAndType(paperId);     //计算题题库 4

        Map<String, Object> map = new HashMap<>();
        map.put("multiQuestionRes",multiQuestionRes);
        map.put("fillQuestionRes",fillQuestionRes);
        map.put("judgeQuestionRes",judgeQuestionRes);
        map.put("textQuestionRes",textQuestionRes);
        map.put("calculationQuestionRes",calculationQuestionRes);
        return  map;
    }

    //根据章节测试编号查询
    @GetMapping("/findPaperById/{paperId}")
    public ApiResult findPaperById(@PathVariable("paperId") Integer paperId) {
        PaperChapter res = paperChapterService.findPaperById(paperId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败", null);
    }

    //查询表中最后一个paperId 实现自增效果
    @GetMapping("/paperChapterPaperId")
    public ApiResult findOnlyPaperId() {
        PaperChapter res = paperChapterService.findOnlyPaperId();
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败", null);
    }
    @DeleteMapping("/deleteChapterTest/{paperId}")
    public ApiResult deleteById(@PathVariable("paperId") Integer paperId){
       return ApiResultHandler.success(paperChapterService.deleteById(paperId));
    }
}
