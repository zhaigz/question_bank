package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select adminName,sex,tel,email,role from admin")
    public List<Admin> findAll();

    @Select("select adminName,sex,tel,email,role from admin where adminId = #{adminId}")
    public Admin findById(Integer adminId);

    @Delete("delete from admin where adminId = #{adminId}")
    public int deleteById(int adminId);

    @Update("update admin set adminName = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},role = #{role} where adminId = #{adminId}")
    public int update(Admin admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert("insert into admin(adminName,sex,tel,email,pwd,role) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{role})")
    public int add(Admin admin);
}
