package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.JudgeQuestion;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

//判断题

@Mapper
public interface JudgeQuestionMapper {

    @Select("select * from judge_question where questionId in (select questionId from paper_manage where questionType = 3 and paperId = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    @Select("select * from judge_question")
    IPage<JudgeQuestion> findAll(Page page);

    @Select("SELECT DISTINCT judge_question.questionId,question,section,type,level,paperId FROM judge_question LEFT JOIN paper_manage ON judge_question.questionId=paper_manage.questionId AND questionType=3 AND paperId=#{paperId} OR paperId=NULL ORDER BY judge_question.questionId ASC")
    IPage<QuestionPaper> findQuestionPaper(Page page, Integer paperId);

    /**
     * 查询最后一条记录的questionId
     * @return JudgeQuestion
     */
    @Select("select questionId from judge_question order by questionId desc limit 1")
    JudgeQuestion findOnlyQuestionId();

    @Insert("insert into judge_question(subject,question,rightAnswer,analysis,level,section,type) values " +
            "(#{subject},#{question},#{rightAnswer},#{analysis},#{level},#{section},#{type})")
    int add(JudgeQuestion judgeQuestion);

    @Select("select questionId from judge_question  where subject=#{subject} and level=#{level}  order by rand() desc limit #{judgeNumber}")
    List<Integer> findBySubject(String subject,Integer level,Integer judgeNumber);

    @Select("select * from judge_question where questionId=#{questionId}")
    JudgeQuestion findJudgeQuestionById(Integer questionId);

    @Update("update judge_question set question = #{question},section = #{section},level = #{level},score=#{score},analysis = #{analysis},rightAnswer = #{rightAnswer}" +
            "where questionId = #{questionId}")
    int update(JudgeQuestion judgeQuestion);

    @Delete("delete from judge_question where questionId=#{questionId}")
    int deleteById(Integer questionId);

    @Select("SELECT questionId FROM `judge_question` where section=#{section} and level=#{level}")
    List<Integer> findByChapter(String section, Integer level);

    @Select("select * from judge_question where questionId in (select questionId from paper_chapter where questionType = 3 and paperId = #{paperId})")
    List<JudgeQuestion> findChapterByIdAndType(Integer paperId);
}
