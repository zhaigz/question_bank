package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.*;
import com.example.service.impl.*;
import com.example.util.ApiResultHandler;
import com.example.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AnswerController {

    @Autowired
    private AnswerServiceImpl answerService;
    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;
    @Autowired
    private FillQuestionServiceImpl fillQuestionService;
    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;
    @Autowired
    private TextQuestionServiceImpl textQuestionService;
    @Autowired
    private CalculationQuestionServiceImpl calculationQuestionService;

    //不分页查询所有试题信息
    @GetMapping("/answers")
    public ApiResult findAllQuestion(){
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", answerService.findAll());
        return apiResult;
    }

    //分页查询所有试题信息
    @GetMapping("/answers/{page}/{size}")
    public ApiResult findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
       Page<AnswerVO> answerVOPage = new Page<>(page,size);
       IPage<AnswerVO> answerVOIPage = answerService.findAll(answerVOPage);
       return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);
    }
    //根据id和type查询对应题目信息
    @GetMapping("/answer/{questionId}/{type}")
    public ApiResult findQuestionByIdAndType(@PathVariable("questionId") Integer questionId,@PathVariable("type") String type) {
        // System.out.println(questionId);
        // System.out.println(type);
        if (type.equals("选择题")){
            MultiQuestion res1 = multiQuestionService.findMultiQuestionById(questionId);
            if (res1 != null) {
                return ApiResultHandler.buildApiResult(200,"请求成功",res1);
            } else {
                return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
            }
        } else if(type.equals("填空题")){
            FillQuestion res2 = fillQuestionService.findFillQuestionById(questionId);
            if (res2 != null) {
                return ApiResultHandler.buildApiResult(200,"请求成功",res2);
            } else {
                return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
            }
        }else if (type.equals("判断题")){
            JudgeQuestion res3 = judgeQuestionService.findJudgeQuestionById(questionId);
            if (res3 != null) {
                return ApiResultHandler.buildApiResult(200,"请求成功",res3);
            } else {
                return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
            }
        }else if (type.equals("简答题")){
            TextQuestion res4 = textQuestionService.findTextQuestionById(questionId);
            if (res4 != null) {
                return ApiResultHandler.buildApiResult(200,"请求成功",res4);
            } else {
                return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
            }
        }else {
            CalculationQuestion res5 = calculationQuestionService.findCalculationQuestionById(questionId);
            if (res5 != null) {
                return ApiResultHandler.buildApiResult(200,"请求成功",res5);
            } else {
                return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
            }
        }

    }

    //删除学生信息
    @DeleteMapping("/answer/{questionId}/{type}")
    public ApiResult deleteQuestionByIdAndType(@PathVariable("questionId") Integer questionId,@PathVariable("type") String type) {
        if(type.equals("选择题")){
            return ApiResultHandler.buildApiResult(200,"删除成功",multiQuestionService.deleteById(questionId));
        }else if(type.equals("填空题")){
            return ApiResultHandler.buildApiResult(200,"删除成功",fillQuestionService.deleteById(questionId));
        }else if(type.equals("判断题")){
            return ApiResultHandler.buildApiResult(200,"删除成功",judgeQuestionService.deleteById(questionId));
        }else if (type.equals("简答题")){
            return ApiResultHandler.buildApiResult(200,"删除成功",textQuestionService.deleteById(questionId));
        }else {
            return ApiResultHandler.buildApiResult(200,"删除成功",calculationQuestionService.deleteById(questionId));
        }

    }
}
