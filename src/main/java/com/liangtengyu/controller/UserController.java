package com.liangtengyu.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lty
 * @Date: 2020/12/22 16:06
 */
@RestController("/user")
@Log
public class UserController {

    @RequestMapping("/test")
    public String test(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }
}
