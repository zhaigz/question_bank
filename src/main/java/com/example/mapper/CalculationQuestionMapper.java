package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.CalculationQuestion;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CalculationQuestionMapper {
    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into calculation_question(subject,question,rightAnswer,analysis,level,section,type) values " +
            "(#{subject,},#{question},#{rightAnswer},#{analysis},#{level},#{section},#{type})")
    int add(CalculationQuestion calculationQuestion);

    @Update("update calculation_question set question = #{question},section = #{section},level = #{level},score=#{score},analysis = #{analysis},rightAnswer = #{rightAnswer}" +
            "where questionId = #{questionId}")
    int update(CalculationQuestion calculationQuestion);

    @Select("SELECT DISTINCT calculation_question.questionId,question,section,type,level,paperId FROM calculation_question LEFT JOIN paper_manage ON calculation_question.questionId=paper_manage.questionId AND questionType=5 AND paperId=#{paperId} OR paperId=NULL ORDER BY calculation_question.questionId ASC")
    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId);

    @Select("select * from calculation_question where questionId=#{questionId}")
    CalculationQuestion findCalculationQuestionById(Integer questionId);

    @Delete("delete from calculation_question where questionId=#{questionId}")
    int deleteById(Integer questionId);

    @Select("select * from calculation_question where questionId in (select questionId from paper_manage where questionType = 5 and paperId = #{paperId})")
    List<CalculationQuestion> findByIdAndType(Integer paperId);

    @Select("select questionId from calculation_question where subject = #{subject} and level=#{level} order by rand() desc limit #{calculationNumber}")
    List<Integer> findBySubject(String subject, Integer level, Integer calculationNumber);

    @Select("SELECT questionId FROM `calculation_question` where section=#{section} and level=#{level}")
    List<Integer> findByChapter(String section, Integer level);

    @Select("select * from text_question where questionId in (select questionId from paper_chapter where questionType = 4 and paperId = #{paperId})")
    List<CalculationQuestion> findChapterByIdAndType(Integer paperId);
}
