package com.liangtengyu.config.authentication;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: lty
 * @Date: 2020/12/24 14:40
 */
@Data
public class UrlGrantedAuthority implements GrantedAuthority {
    private String path;
    private String methodName;

    public UrlGrantedAuthority(String path, String methodName) {
        this.path = path;
        this.methodName = methodName;
    }

    @Override
    public String getAuthority() {
        return methodName;
    }
}
