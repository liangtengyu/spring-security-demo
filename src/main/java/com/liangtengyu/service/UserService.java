package com.liangtengyu.service;

import com.liangtengyu.dao.UserDao;
import com.liangtengyu.entity.Resource;
import com.liangtengyu.entity.Role;
import com.liangtengyu.entity.UrlGrantedAuthority;
import com.liangtengyu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2020/12/23 14:21
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();

        roles.forEach(role -> {//循环roles
            List<Resource> resources = role.getResources();
            resources.forEach(resource -> {//循环resources
                 authorities.add(//添加GrantedAuthority实现类
                         new UrlGrantedAuthority(resource.getResourcePath(),resource.getResourceName())
                 );
            });
            user.setGrantedAuthority(authorities);//将这个用户的权限列表加载到用户的实体类中
        });
        //获取Use
        return user;
    }
}
