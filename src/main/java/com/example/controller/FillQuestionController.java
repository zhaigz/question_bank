package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.FillQuestion;
import com.example.entity.MultiQuestion;
import com.example.service.impl.FillQuestionServiceImpl;
import com.example.util.ApiResultHandler;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FillQuestionController {

    @Autowired
    private FillQuestionServiceImpl fillQuestionService;

    @PostMapping("/fillQuestion")
    public ApiResult add(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/fillQuestionId")
    public ApiResult findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    //未用
    @GetMapping("/findAllFillQuestions/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<FillQuestion> questionPage = new Page<>(page,size);
        IPage<FillQuestion> questionIPage = fillQuestionService.findAll(questionPage);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }

    //题目和试卷左连接分页查询
    @GetMapping("/findFillQuestionPaper/{paperId}/{page}/{size}")
    public ApiResult findQuestionPaper(@PathVariable("paperId") Integer paperId, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<QuestionPaper> questionPage = new Page<>(page,size);
        IPage<QuestionPaper> questionIPage = fillQuestionService.findQuestionPaper(questionPage,paperId);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }


    @PutMapping("/fillQuestion")
    public ApiResult update(@RequestBody FillQuestion fillQuestion){
        int res=fillQuestionService.update(fillQuestion);
        if (res!=0){
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        }
    }
}
