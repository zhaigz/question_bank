package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MultiQuestion;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

//选择题
@Mapper
public interface MultiQuestionMapper {
    /**
     * select * from multiquestions where questionId in (
     * 	select questionId from papermanage where questionType = 1 and paperId = 1001
     * )
     */
    @Select("select * from multi_question where questionId in (select questionId from paper_manage where questionType = 1 and paperId = #{paperId})")
    List<MultiQuestion> findByIdAndType(Integer PaperId);

    @Select("select * from multi_question")
    IPage<MultiQuestion> findAll(Page page);

    //questionType=1 对应选择题
    @Select("SELECT DISTINCT multi_question.questionId,question,section,type,level,paperId FROM multi_question LEFT JOIN paper_manage ON multi_question.questionId=paper_manage.questionId AND questionType=1 AND paperId=#{paperId} OR paperId=NULL ORDER BY multi_question.questionId ASC")
    IPage<QuestionPaper> findQuestionPaper(Page page, Integer paperId);

    /**
     * 查询最后一条记录的questionId
     * @return MultiQuestion
     */ MultiQuestion findOnlyQuestionId();

    @Select("select questionId from multi_question  where subject =#{subject} and level=#{level} order by rand() desc limit #{changeNumber}")
    List<Integer> findBySubject(String subject,Integer level,Integer changeNumber);

    @Select("select * from multi_question where questionId=#{questionId}")
    MultiQuestion findMultiQuestionById(Integer questionId);

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into multi_question(subject,question,answerA,answerB,answerC,answerD,rightAnswer,analysis,section,level,type) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{analysis},#{section},#{level},#{type})")
    int add(MultiQuestion multiQuestion);

    @Update("update multi_question set question = #{question},section = #{section},level = #{level},score=#{score},analysis = #{analysis}," +
            "answerA = #{answerA},answerB = #{answerB},answerC = #{answerC},answerD = #{answerD},rightAnswer = #{rightAnswer}" +
            "where questionId = #{questionId}")
    int update(MultiQuestion multiQuestion);

    @Delete("delete from multi_question where questionId=#{questionId}")
    int deleteById(Integer questionId);

    @Select("SELECT questionId FROM `multi_question` where section=#{section} and level=#{level}")
    List<Integer> findByChapter(String section, Integer level);

    @Select("select * from multi_question where questionId in (select questionId from paper_chapter where questionType = 1 and paperId = #{paperId})")
    List<MultiQuestion> findChapterByIdAndType(Integer paperId);
}
