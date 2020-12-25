package com.liangtengyu.config.handler;

import com.alibaba.fastjson.JSON;
import com.liangtengyu.utils.ResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lty
 * @Date: 2020/12/25 14:00
 */

@Component
public class AuthAccessDeniedHandler    implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //使用json返回登录成功的用户信息
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.failed("403","您没有权限"),
                        true)
        );

    }

}
