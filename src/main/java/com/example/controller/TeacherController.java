package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.Teacher;
import com.example.service.impl.TeacherServiceImpl;
import com.example.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    private TeacherServiceImpl teacherService;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ApiResult findAll(){
        ApiResult apiResult;
        apiResult=ApiResultHandler.buildApiResult(200,"查询所有老师",teacherService.findAll());
        return apiResult;
    }

    @GetMapping("/teachers/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);
        IPage<Teacher> teacherIPage = teacherService.findAll(teacherPage);

        return ApiResultHandler.buildApiResult(200,"查询所有教师",teacherIPage);
    }

    @GetMapping("/teacher/{teacherId}")
    public ApiResult findById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.findById(teacherId));
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ApiResult deleteById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.deleteById(teacherId));
    }

    @PutMapping("/teacher")
    public ApiResult update(@RequestBody Teacher teacher){
        return ApiResultHandler.success(teacherService.update(teacher));
    }

    @PostMapping("/teacher")
    public ApiResult add(@RequestBody Teacher teacher){
        teacher.setPwd("123456");
        teacher.setRole("1");//设置教师角色为1
        return ApiResultHandler.success(teacherService.add(teacher));
    }
}
