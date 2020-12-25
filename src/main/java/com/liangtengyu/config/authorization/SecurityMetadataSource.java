package com.liangtengyu.config.authorization;

import com.liangtengyu.dao.UserDao;
import com.liangtengyu.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2020/12/25 14:12
 * 获取数据库中的Path信息 匹配路径
 */
@Component
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
     UserDao userDao;

    private static HashMap<String,Collection<ConfigAttribute>> map = null;

    //加载数据库中的所有resource数据
    private  void getResource(){
        map = new HashMap<>();
        ConfigAttribute rname;
        ConfigAttribute path;
        Collection<ConfigAttribute> list = new ArrayList<>();
        List<Resource> allResource = userDao.getAllResource();
        for (Resource resource : allResource) {
            String resourceName = resource.getResourceName();
            String resourcePath = resource.getResourcePath();
            rname= new SecurityConfig(resourceName);
            path= new SecurityConfig(resourcePath);
            list.add(rname);
            list.add(path);
            map.put(resourcePath, list);
        }
    }

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，
     * 进行判定用户是否有此权限。如果不在权限表中则放行。
     * @param object
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            getResource();
        }
        HttpServletRequest httpRequest = ((FilterInvocation) object).getHttpRequest();

        for (String key : map.keySet()) {
            if (new AntPathRequestMatcher(key).matches(httpRequest)) {
                return map.get(key);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;//开启 true
    }
}
