package com.liangtengyu.entity;

import lombok.Data;

/**
 * @Author: lty
 * @Date: 2020/12/25 13:42
 */
@Data
public class Result {
    private String code;
    private String msg;
    private Object data;
}
