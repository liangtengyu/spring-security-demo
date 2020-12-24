package com.liangtengyu.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: lty
 * @Date: 2020/12/23 14:46
 */
@Data
public class Role {
    private long id;
    private long userId;
    private String roleName;
    private String remark;
    private List<Resource> resources;//一个角色,对应多个资源
}
