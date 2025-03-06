package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ApiResult;
import com.example.entity.Message;
import com.example.service.impl.MessageServiceImpl;
import com.example.util.ApiResultHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableScheduling
public class MessageController {
    private static final Log log = LogFactory.getLog(MessageController.class);
    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping("/messages/{page}/{size}")
    public ApiResult<Message> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Message> messagePage = new Page<>(page,size);
        IPage<Message> all = messageService.findAll(messagePage);
        return ApiResultHandler.buildApiResult(200,"查询所有留言",all);
    }

    @GetMapping("/message/{id}")
    public ApiResult findById(@PathVariable("id") Integer id) {
        Message res = messageService.findById(id);
        return ApiResultHandler.buildApiResult(200,"根据Id查询",res);
    }

    @DeleteMapping("/message/{id}")
    public int delete(@PathVariable("id") Integer id) {
        int res = messageService.delete(id);
        return res;
    }

    @PostMapping("/message")
    public ApiResult add(@RequestBody Message message) {
        int res = messageService.add(message);
        if (res == 0) {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        } else {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
    }


//    @Scheduled(cron = "0/5 * * * * ? ")
    public void test(){
        System.out.println("5555555555555555555555555555555555555555555");
        log.debug("5555555555555555555555555555555555555555555");
        log.info("5555555555555555555555555555555555555555555");
    }
}
