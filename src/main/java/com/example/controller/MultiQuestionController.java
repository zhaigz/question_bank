package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.MultiQuestion;
import com.example.entity.Student;
import com.example.service.impl.MultiQuestionServiceImpl;
import com.example.util.ApiResultHandler;
import com.example.vo.AnswerVO;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MultiQuestionController {

    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;

    @GetMapping("/multiQuestionId")
    public ApiResult findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    //未用
    @GetMapping("/findAllMultiQuestions/{page}/{size}")
    public ApiResult findByQuestionType(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<MultiQuestion> questionPage = new Page<>(page,size);
        IPage<MultiQuestion> questionIPage = multiQuestionService.findAll(questionPage);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }

    //题目和试卷左连接分页查询
    @GetMapping("/findMulQuestionPaper/{paperId}/{page}/{size}")
    public ApiResult findQuestionPaper(@PathVariable("paperId")Integer paperId,@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<QuestionPaper> questionPage = new Page<>(page,size);
        IPage<QuestionPaper> questionIPage = multiQuestionService.findQuestionPaper(questionPage,paperId);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }

    @PostMapping("/MultiQuestion")
    public ApiResult add(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0) {

            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    //修改学生信息
    @PutMapping("/multiQuestion")
    public ApiResult update(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.update(multiQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
}
