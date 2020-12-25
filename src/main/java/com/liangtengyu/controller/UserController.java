package com.liangtengyu.controller;

import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lty
 * @Date: 2020/12/22 16:06
 */
@RestController
@Log
public class UserController {

    @PreAuthorize("hasPermission('/test','r')")
    @RequestMapping("/test")
    public String test(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }

    @RequestMapping("/u")
    public String utest(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }

    @PreAuthorize("hasPermission('/admin','')")
    @RequestMapping("/admin")
    public String admin(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }
    @RequestMapping("/test/log")
    public String ltest(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }

    @PreAuthorize("hasPermission('/api/log','r')")
    @RequestMapping("/api/log")
    public String api(){
        log.info("请求了接口完成返回了");
        return "请求了接口完成返回了";
    }
}
