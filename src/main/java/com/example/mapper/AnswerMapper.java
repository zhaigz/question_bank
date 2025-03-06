package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface AnswerMapper {
    @Select("select questionId, question, subject, score, section,level,type from multi_question " +
            "union select questionId, question, subject, score, section,level,type from judge_question " +
            "union select questionId, question, subject, score, section,level,type from fill_question " +
            "union select questionId, question, subject, score, section,level,type from text_question " +
            "union select questionId, question, subject, score, section,level,type from calculation_question ")
    List<AnswerVO> findAll();

    @Select("select questionId, question, subject, score, section,level,type from multi_question " +
            "union select questionId, question, subject, score, section,level,type from judge_question " +
            "union select questionId, question, subject, score, section,level,type from fill_question " +
            "union select questionId, question, subject, score, section,level,type from text_question " +
            "union select questionId, question, subject, score, section,level,type from calculation_question ")
    IPage<AnswerVO> findAll(Page page);


}
