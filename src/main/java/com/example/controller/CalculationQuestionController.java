package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.CalculationQuestion;
import com.example.entity.TextQuestion;
import com.example.service.impl.CalculationQuestionServiceImpl;
import com.example.service.impl.TextQuestionServiceImpl;
import com.example.util.ApiResultHandler;
import com.example.vo.QuestionPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: CalculationQuestionController
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/14 19:03
 * @Version: 1.0
 **/
@RestController
public class CalculationQuestionController {
    @Autowired
    private CalculationQuestionServiceImpl calculationQuestionService;

    @PostMapping("/calculationQuestion")
    public ApiResult add(@RequestBody CalculationQuestion calculationQuestion) {
        int res = calculationQuestionService.add(calculationQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    @PutMapping("/calculationQuestion")
    public ApiResult update(@RequestBody CalculationQuestion calculationQuestion){
        int res=calculationQuestionService.update(calculationQuestion);
        if (res!=0){
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        }
    }

    //题目和试卷左连接分页查询
    @GetMapping("/findCalculationQuestionPaper/{paperId}/{page}/{size}")
    public ApiResult findQuestionPaper(@PathVariable("paperId") Integer paperId, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<QuestionPaper> questionPage = new Page<>(page,size);
        IPage<QuestionPaper> questionIPage = calculationQuestionService.findQuestionPaper(questionPage,paperId);
        return ApiResultHandler.buildApiResult(200,"查询成功",questionIPage);
    }

}
