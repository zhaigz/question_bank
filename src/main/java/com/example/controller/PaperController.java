package com.example.controller;

import com.example.entity.*;
import com.example.service.impl.*;
import com.example.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaperController {

    @Autowired
    private PaperServiceImpl paperService;
    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;
    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;
    @Autowired
    private FillQuestionServiceImpl fillQuestionService;
    @Autowired
    private TextQuestionServiceImpl textQuestionService;
    @Autowired
    private CalculationQuestionServiceImpl calculationQuestionService;

    @GetMapping("/papers")
    public ApiResult<PaperManage> findAll() {
       ApiResult res =  ApiResultHandler.buildApiResult(200,"请求成功",paperService.findAll());
       return  res;
    }

    @GetMapping("/paper/{paperId}")
    public Map<String, Object> findById(@PathVariable("paperId") Integer paperId) {
        List<MultiQuestion> multiQuestionRes = multiQuestionService.findByIdAndType(paperId);   //选择题题库 1
        List<FillQuestion> fillQuestionRes = fillQuestionService.findByIdAndType(paperId);     //填空题题库 2
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findByIdAndType(paperId);   //判断题题库 3
        List<TextQuestion> textQuestionRes = textQuestionService.findByIdAndType(paperId);     //简答题题库 4
        List<CalculationQuestion> calculationQuestionRes = calculationQuestionService.findByIdAndType(paperId);     //计算题题库 4

        Map<String, Object> map = new HashMap<>();
        map.put("multiQuestionRes",multiQuestionRes);
        map.put("fillQuestionRes",fillQuestionRes);
        map.put("judgeQuestionRes",judgeQuestionRes);
        map.put("textQuestionRes",textQuestionRes);
        map.put("calculationQuestionRes",calculationQuestionRes);
        return  map;
    }

    @PostMapping("/paperManage")
    public ApiResult add(@RequestBody PaperManage paperManage) {
        int res = paperService.add(paperManage);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    //将题目移除该试卷
    @DeleteMapping("/deleteQuestionPaper/{paperId}/{questionId}")
    public ApiResult delete(@PathVariable("paperId") Integer paperId,@PathVariable("questionId") Integer questionId){
        int res=paperService.delete(paperId,questionId);
        if (res!=0){
            return ApiResultHandler.buildApiResult(200,"删除成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"删除失败",res);
    }
}
