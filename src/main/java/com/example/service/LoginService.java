package com.example.service;

import com.example.entity.Admin;
import com.example.entity.Student;
import com.example.entity.Teacher;

public interface LoginService {

    public Admin adminLogin(Integer username, String password);

    public Teacher teacherLogin(Integer username, String password);

    public Student studentLogin(Integer username, String password);
}
