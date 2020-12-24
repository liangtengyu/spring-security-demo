package com.liangtengyu.dao;

import com.liangtengyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Author: lty
 * @Date: 2020/12/23 14:26
 */
@Mapper
@Repository
public interface UserDao {

    User getUserByName(String name);
    int  getCounts(String name);
}
