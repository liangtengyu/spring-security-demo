package com.liangtengyu;

import com.liangtengyu.dao.UserDao;
import com.liangtengyu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: lty
 * @Date: 2020/12/23 17:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityApplication.class)
public class AppTest {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Test
    public void test(){

        System.out.println(userService.loadUserByUsername("lty"));
    }
}
