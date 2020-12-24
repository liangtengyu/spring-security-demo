package com.liangtengyu.entity;

import lombok.Data;

/**
 * @Author: lty
 * @Date: 2020/12/23 14:48
 */
@Data
public class Resource {
    private long id;
    /**控制的url*/
    private String resourcePath;
    /**资源名称*/
    private String resourceName;

    private String remark;
    private int roleId;





}
