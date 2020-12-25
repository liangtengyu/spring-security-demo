package com.liangtengyu.config.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: lty
 * @Date: 2020/12/24 15:45
 */

/**
 * AuthenticationManager
 * @return 管理providers 可提供多个实现
 * @date   2020/12/25 10:22
 */
@Component
public class MyAuthenticationManager implements AuthenticationManager {
    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = daoAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}
