package com.example.mapper;

import com.example.entity.Admin;
import com.example.entity.Student;
import com.example.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    // @Select("select adminId,adminName,sex,tel,email,cardId,role from admin where adminId = #{username} and pwd = #{password}")
    public Admin adminLogin(Integer username, String password);

    @Select("select teacherId,teacherName,institute,sex,tel," +
            "type,role from teacher where teacherId = #{username} and pwd = #{password}")
    public Teacher teacherLogin(Integer username, String password);

    @Select("select studentId,studentName,grade,major,clazz,institute,tel," +
            "sex,role from student where studentId = #{username} and pwd = #{password}")
    public Student studentLogin(Integer username,String password);
}
