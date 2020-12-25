package com.liangtengyu.config.authorization;

import com.liangtengyu.config.authentication.UrlGrantedAuthority;
import com.liangtengyu.entity.User;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author: lty
 * @Date: 2020/12/25 15:30
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {
    /**
     * 自定义验证方法
     * @param authentication        登录的时候存储的用户信息
     * @param targetDomainObject    @PreAuthorize("hasPermission('/hello/**','r')") 中hasPermission的第一个参数
     * @param permission            @PreAuthorize("hasPermission('/hello/**','r')") 中hasPermission的第二个参数
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        User principal = (User)authentication.getPrincipal();
        Collection<? extends GrantedAuthority> grantedAuthority = principal.getGrantedAuthority();
        for (GrantedAuthority authority : grantedAuthority) {
            UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) authority;
            String path = urlGrantedAuthority.getPath();
            if (targetDomainObject.equals(path)) {
                //判断路径相同后 可以再继续判断  permission
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
