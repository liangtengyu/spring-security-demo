package com.liangtengyu.dao;

import com.liangtengyu.entity.Resource;
import com.liangtengyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author: lty
 * @Date: 2020/12/23 14:26
 */
@Mapper
@Repository
public interface UserDao {

    User getUserByName(String name);
    List<Resource> getAllResource();
}
