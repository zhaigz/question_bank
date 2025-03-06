package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TextQuestion;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

//简答题
@Mapper
public interface TextQuestionMapper {
    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into text_question(subject,question,rightAnswer,analysis,level,section,type) values " +
            "(#{subject,},#{question},#{rightAnswer},#{analysis},#{level},#{section},#{type})")
    int add(TextQuestion textQuestion);

    @Select("select * from text_question where questionId=#{questionId}")
    TextQuestion findTextQuestionById(Integer questionId);

    @Update("update text_question set question = #{question},section = #{section},level = #{level},score=#{score},analysis = #{analysis},rightAnswer = #{rightAnswer}" +
            "where questionId = #{questionId}")
    int update(TextQuestion textQuestion);

    @Delete("delete from text_question where questionId=#{questionId}")
    int deleteById(Integer questionId);

    @Select("select * from text_question where questionId in (select questionId from paper_manage where questionType = 4 and paperId = #{paperId})")
    List<TextQuestion> findByIdAndType(Integer paperId);

    @Select("SELECT DISTINCT text_question.questionId,question,section,type,level,paperId FROM text_question LEFT JOIN paper_manage ON text_question.questionId=paper_manage.questionId AND questionType=4 AND paperId=#{paperId} OR paperId=NULL ORDER BY text_question.questionId ASC")
    IPage<QuestionPaper> findQuestionPaper(Page<QuestionPaper> questionPage, Integer paperId);

    @Select("select questionId from text_question where subject = #{subject} and level=#{level} order by rand() desc limit #{textNumber}")
    List<Integer> findBySubject(String subject, Integer level, Integer textNumber);

    @Select("SELECT questionId FROM `text_question` where section=#{section} and level=#{level}")
    List<Integer> findByChapter(String section, Integer level);

    @Select("select * from text_question where questionId in (select questionId from paper_chapter where questionType = 4 and paperId = #{paperId})")
    List<TextQuestion> findChapterByIdAndType(Integer paperId);
}
