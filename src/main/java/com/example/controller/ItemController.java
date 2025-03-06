package com.example.controller;

import com.example.entity.ApiResult;
import com.example.entity.PaperChapter;
import com.example.entity.PaperManage;
import com.example.service.PaperService;
import com.example.service.impl.*;
import com.example.util.ApiResultHandler;
import com.example.util.RandomNumber;
import com.example.vo.ChapterTest;
import com.example.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//自动组卷
@RestController
public class ItemController {

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
    @Autowired
    PaperServiceImpl paperService;

    //自动组卷
    @PostMapping("/item")
    public ApiResult ItemController(@RequestBody Item item) {
        //试卷难度
        Integer difficultyValue = item.getDifficultyValue();
        // 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        // 判断题
        Integer textNumber = item.getTextNumber();
        // 判断题
        Integer calculationNumber = item.getCalculationNumber();
        //出卷id
        Integer paperId = item.getPaperId();

        // 选择题数据库获取
        List<Integer>  changeNumbers = multiQuestionService.findBySubject(item.getSubject(),difficultyValue, changeNumber);
        if(changeNumbers==null){
            return ApiResultHandler.buildApiResult(400,"选择题数据库获取失败",null);
        }
        for (Integer number : changeNumbers) {
            PaperManage paperManage = new PaperManage(paperId,1,number);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"选择题组卷保存失败",null);
        }

        // 填空题
        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), difficultyValue,fillNumber);
        if(fills==null)
            return ApiResultHandler.buildApiResult(400,"填空题数据库获取失败",null);
        for (Integer fillNum : fills) {
            PaperManage paperManage = new PaperManage(paperId,2,fillNum);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"填空题组卷保存失败",null);
        }
        // 判断题
        List<Integer> judges = judgeQuestionService.findBySubject(item.getSubject(),difficultyValue, judgeNumber);
        if(fills==null)
            return ApiResultHandler.buildApiResult(400,"判断题数据库获取失败",null);
        for (Integer judge : judges) {
            PaperManage paperManage = new PaperManage(paperId,3,judge);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"判断题组卷保存失败",null);
             }
        //简答题
        List<Integer> texts = textQuestionService.findBySubject(item.getSubject(),difficultyValue, textNumber);
        System.out.println("texts"+textNumber);
        if(texts==null)
            return ApiResultHandler.buildApiResult(400,"简答题数据库获取失败",null);
        for (Integer text : texts) {
            PaperManage paperManage = new PaperManage(paperId,4,text);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"简答题组卷保存失败",null);
        }
        //计算题
        List<Integer> calculations = calculationQuestionService.findBySubject(item.getSubject(),difficultyValue, calculationNumber);
        System.out.println("计算题数量"+calculations);
        if(calculations==null)
            return ApiResultHandler.buildApiResult(400,"计算题数据库获取失败",null);
        for (Integer calculation : calculations) {
            PaperManage paperManage = new PaperManage(paperId,5,calculation);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"计算题组卷保存失败",null);
        }

          return ApiResultHandler.buildApiResult(200,"试卷组卷成功",null);
    }
    //学生自定义章节组卷
    @PostMapping("/addChapterTest")
    public ApiResult addChapterTest(@RequestBody ChapterTest chapterTest) {
        Integer paperId = chapterTest.getPaperId();
        //试卷名称
        String paperName=chapterTest.getPaperName();
        //试卷简介
        String description=chapterTest.getDescription();
        //试卷章节
        String[] sections=chapterTest.getSections();
        //试题数量
        Integer[] number=chapterTest.getNumber();
        //试卷难度
        Integer difficultyValue = chapterTest.getDifficultyValue();
        //用户编号
        Integer userId = chapterTest.getUserId();
        //创建时间
        String createTime=chapterTest.getCreateTime();
        // 选择题数据库获取
        List<Integer> allChangeQuestionId=new ArrayList<Integer>();
        for(int i=0;i<sections.length;i++){
            //查询得到符合要求的章节 试题编号总数
            List<Integer> chapterQuestionId= multiQuestionService.findByChapter(sections[i],difficultyValue);
            for (Integer questionId : chapterQuestionId){
                allChangeQuestionId.add(questionId);
            }
        }
        // for (Integer questionId : RandomNumber.getRandomList(allQuestionId,number[0])){
        //     System.out.println("所有符合要求的选择题编号："+questionId);
        // }
        //从符合要求的章节中随机抽取指定数量的选择题
        List<Integer>  changeQuestionId = RandomNumber.getRandomList(allChangeQuestionId,number[0]);
        if(changeQuestionId==null){
            return ApiResultHandler.buildApiResult(400,"选择题数据库获取失败",null);
        }
        for (Integer questionId : changeQuestionId) {
            PaperChapter paperChapter = new PaperChapter(paperId,paperName,description,createTime,1,questionId,userId);
            int index = paperService.addChapterTest(paperChapter);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"选择题组卷保存失败",null);
        }

        // 填空题数据库获取
        List<Integer> allFillQuestionId=new ArrayList<Integer>();
        for(int i=0;i<sections.length;i++){
            //查询得到符合要求的章节 试题编号总数
            List<Integer> chapterQuestionId= fillQuestionService.findByChapter(sections[i],difficultyValue);
            for (Integer questionId : chapterQuestionId){
                allFillQuestionId.add(questionId);
            }
        }
        List<Integer>  fillQuestionIds = RandomNumber.getRandomList(allFillQuestionId,number[1]);
        if(fillQuestionIds==null){
            return ApiResultHandler.buildApiResult(400,"填空题数据库获取失败",null);
        }
        for (Integer questionId : fillQuestionIds) {
            PaperChapter paperChapter = new PaperChapter(paperId,paperName,description,createTime,2,questionId,userId);
            int index = paperService.addChapterTest(paperChapter);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"填空题组卷保存失败",null);
        }

        // 判断题数据库获取
        List<Integer> allJudgeQuestionId=new ArrayList<Integer>();
        for(int i=0;i<sections.length;i++){
            //查询得到符合要求的章节 试题编号总数
            List<Integer> chapterQuestionId= judgeQuestionService.findByChapter(sections[i],difficultyValue);
            for (Integer questionId : chapterQuestionId){
                allJudgeQuestionId.add(questionId);
            }
        }
        List<Integer>  judgeQuestionIds = RandomNumber.getRandomList(allJudgeQuestionId,number[2]);
        if(judgeQuestionIds==null){
            return ApiResultHandler.buildApiResult(400,"判断题数据库获取失败",null);
        }
        for (Integer questionId : judgeQuestionIds) {
            PaperChapter paperChapter = new PaperChapter(paperId,paperName,description,createTime,3,questionId,userId);
            int index = paperService.addChapterTest(paperChapter);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"判断题组卷保存失败",null);
        }
        // 简答题数据库获取
        List<Integer> allTextQuestionId=new ArrayList<Integer>();
        for(int i=0;i<sections.length;i++){
            //查询得到符合要求的章节 试题编号总数
            List<Integer> chapterQuestionId= textQuestionService.findByChapter(sections[i],difficultyValue);
            for (Integer questionId : chapterQuestionId){
                allTextQuestionId.add(questionId);
            }
        }
        List<Integer>  textQuestionIds = RandomNumber.getRandomList(allTextQuestionId,number[3]);
        if(textQuestionIds==null){
            return ApiResultHandler.buildApiResult(400,"简答题数据库获取失败",null);
        }
        for (Integer questionId : textQuestionIds) {
            PaperChapter paperChapter = new PaperChapter(paperId,paperName,description,createTime,4,questionId,userId);
            int index = paperService.addChapterTest(paperChapter);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"简答题组卷保存失败",null);
        }

        // 计算题数据库获取
        List<Integer> allCalculationQuestionId=new ArrayList<Integer>();
        for(int i=0;i<sections.length;i++){
            //查询得到符合要求的章节 试题编号总数
            List<Integer> chapterQuestionId= calculationQuestionService.findByChapter(sections[i],difficultyValue);
            for (Integer questionId : chapterQuestionId){
                allCalculationQuestionId.add(questionId);
            }
        }
        List<Integer>  calculationQuestionIds = RandomNumber.getRandomList(allCalculationQuestionId,number[4]);
        if(calculationQuestionIds==null){
            return ApiResultHandler.buildApiResult(400,"计算题数据库获取失败",null);
        }
        for (Integer questionId : calculationQuestionIds) {
            PaperChapter paperChapter = new PaperChapter(paperId,paperName,description,createTime,5,questionId,userId);
            int index = paperService.addChapterTest(paperChapter);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"计算题组卷保存失败",null);
        }



        return ApiResultHandler.buildApiResult(200,"试卷组卷成功",null);
    }


}
