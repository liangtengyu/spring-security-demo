package com.liangtengyu.config.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: lty
 * @Date: 2020/12/25 15:01
 */
@Component
public class UserFilterSecurityInterceptor   extends AbstractSecurityInterceptor implements Filter {
    @Autowired
    SecurityMetadataSource securityMetadataSource;


    @Autowired
    public void setPahtAccessDecisionManager(PathAccessDecisionManager accessDecisionManager) {
        super.setAccessDecisionManager(accessDecisionManager);
    }

    //f里面有一个被拦截的url
    //里面调用SecurityMetadataSource的getAttributes(Object object)这个方法获取f对应的所有权限
    //再调用AccessDecisionManager的decide方法来校验用户的权限是否足够
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation f = new FilterInvocation(servletRequest, servletResponse, filterChain);
        InterceptorStatusToken interceptorStatusToken = super.beforeInvocation(f);
        try {
            //执行下一个拦截器
            f.getChain().doFilter(servletRequest, servletResponse);
        } finally {
            afterInvocation(interceptorStatusToken, null);
        }
    }




    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
}
