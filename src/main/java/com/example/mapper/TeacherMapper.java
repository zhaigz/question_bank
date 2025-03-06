package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher")
    IPage<Teacher>  findAll(Page page);

    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Select("select * from teacher where teacherId = #{teacherId}")
    public Teacher findById(Integer teacherId);

    @Delete("delete from teacher where teacherId = #{teacherId}")
    public int deleteById(Integer teacherId);

    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
            "tel = #{tel},pwd = #{pwd}," +
            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    public int update(Teacher teacher);

    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
    @Insert("insert into teacher(teacherName,sex,tel,pwd,role,type,institute) " +
            "values(#{teacherName},#{sex},#{tel},#{pwd},#{role},#{type},#{institute})")
    public int add(Teacher teacher);
}
