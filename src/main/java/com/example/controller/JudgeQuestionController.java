package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.FillQuestion;
import com.example.entity.JudgeQuestion;
import com.example.service.impl.JudgeQuestionServiceImpl;
import com.example.util.ApiResultHandler;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JudgeQuestionController {

    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;

    @PostMapping("/judgeQuestion")
    public ApiResult add(@RequestBody JudgeQuestion judgeQuestion) {
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/judgeQuestionId")
    public ApiResult findOnlyQuestionId() {
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return  ApiResultHandler.buildApiResult(200,"查询成功",res);
    }
    //未用
    @GetMapping("/findAllJudgeQuestions/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<JudgeQuestion> questionPage = new Page<>(page,size);
        IPage<JudgeQuestion> questionIPage = judgeQuestionService.findAll(questionPage);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }

    //题目和试卷左连接分页查询
    @GetMapping("/findJudgeQuestionPaper/{paperId}/{page}/{size}")
    public ApiResult findQuestionPaper(@PathVariable("paperId") Integer paperId,@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<QuestionPaper> questionPage = new Page<>(page,size);
        IPage<QuestionPaper> questionIPage = judgeQuestionService.findQuestionPaper(questionPage,paperId);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }


    @PutMapping("/judgeQuestion")
    public ApiResult update(@RequestBody JudgeQuestion judgeQuestion){
        int res = judgeQuestionService.update(judgeQuestion);
        if(res!=0){
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }else {
            return ApiResultHandler.buildApiResult(400,"更新失败",res);
        }
    }
}
