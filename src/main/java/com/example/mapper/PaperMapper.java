package com.example.mapper;

import com.example.entity.PaperChapter;
import com.example.entity.PaperManage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperMapper {
    @Select("select paperId, questionType,questionId from paper_manage")
    List<PaperManage> findAll();

    @Select("select paperId, questionType,questionId from paper_manage where paperId = #{paperId}")
    List<PaperManage> findById(Integer paperId);

    @Insert("insert into paper_manage(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(PaperManage paperManage);

    @Delete("delete from paper_manage where paperId=#{paperId} and questionId=#{questionId}")
    int delete(Integer paperId,Integer questionId);

    @Insert("insert into paper_chapter(paperId,paperName,description,questionType,questionId,studentId,createTime) values " +
            "(#{paperId},#{paperName},#{description},#{questionType},#{questionId},#{studentId},#{createTime})")
    int addChapterTest(PaperChapter paperChapter);
}
