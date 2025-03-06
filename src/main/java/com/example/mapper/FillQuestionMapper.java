package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.FillQuestion;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

//填空题
@Mapper
public interface FillQuestionMapper {

    @Select("select * from fill_question where questionId in (select questionId from paper_manage where questionType = 2 and paperId = #{paperId})")
    List<FillQuestion> findByIdAndType(Integer paperId);

    @Select("select * from fill_question")
    IPage<FillQuestion> findAll(Page page);

    @Select("SELECT DISTINCT fill_question.questionId,question,section,type,level,paperId FROM fill_question LEFT JOIN paper_manage ON fill_question.questionId=paper_manage.questionId AND questionType=2 AND paperId=#{paperId} OR paperId=NULL ORDER BY fill_question.questionId ASC")
    IPage<QuestionPaper> findQuestionPaper(Page page,Integer paperId);

    /**
     * 查询最后一条questionId
     * @return FillQuestion
     */
    @Select("select questionId from fill_question order by questionId desc limit 1")
    FillQuestion findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into fill_question(subject,question,rightAnswer,analysis,level,section,type) values " +
            "(#{subject,},#{question},#{rightAnswer},#{analysis},#{level},#{section},#{type})")
    int add(FillQuestion fillQuestion);

    @Select("select questionId from fill_question where subject = #{subject} and level=#{level} order by rand() desc limit #{fillNumber}")
    List<Integer> findBySubject(String subject,Integer level,Integer fillNumber);

    @Select("select * from fill_question where questionId=#{questionId}")
    FillQuestion findFillQuestionById(Integer questionId);

    @Update("update fill_question set question = #{question},section = #{section},level = #{level},score=#{score},analysis = #{analysis},rightAnswer = #{rightAnswer}" +
            "where questionId = #{questionId}")
    int update(FillQuestion fillQuestion);

    @Delete("delete from fill_question where questionId=#{questionId}")
    int deleteById(Integer questionId);

    @Select("SELECT questionId FROM `fill_question` where section=#{section} and level=#{level}")
    List<Integer> findByChapter(String section, Integer level);

    @Select("select * from fill_question where questionId in (select questionId from paper_chapter where questionType = 2 and paperId = #{paperId})")
    List<FillQuestion> findChapterByIdAndType(Integer paperId);
}
