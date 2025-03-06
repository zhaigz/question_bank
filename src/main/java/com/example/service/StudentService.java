package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Student;

import java.util.List;

public interface StudentService {

    IPage<Student> findAll(Page<Student> page);

    Student findById(Integer studentId);

    int deleteById(Integer studentId);

    int update(Student student);

    int updatePwd(Student student);
    int add(Student student);

    List<Student> findAll();
}
