package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ExamManage;
import com.example.entity.PaperChapter;
import com.example.vo.QuestionPaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperChapterMapper {
    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     * @return paperId
     */
    @Select("select paperId from paper_chapter order by paperId desc limit 1")
    PaperChapter findOnlyPaperId();

    @Select("SELECT DISTINCT paperId,paperName,description,createTime FROM paper_chapter where studentId=#{studentId}")
    IPage<PaperChapter> findByStudentId(Page page, Integer studentId);

    @Select("select DISTINCT paperName,description,createTime from paper_chapter where paperId=#{paperId}")
    PaperChapter findPaperById(Integer paperId);

    @Select("select DISTINCT paperName,createTime,description from paper_chapter where studentId=#{studentId} order by paperId desc ")
    List<PaperChapter> findAllBYStudentId(Integer studentId);

    @Delete("delete from paper_chapter where paperId=#{paperId}")
    int deleteById(Integer paperId);
}
