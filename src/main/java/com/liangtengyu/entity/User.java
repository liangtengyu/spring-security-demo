package com.liangtengyu.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2020/12/22 16:04
 */


@Data
public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean expired;
    private boolean locked;
    private boolean enabled;
    private List<Role> roles;//一个账号 可有多个角色

    private Collection<? extends GrantedAuthority> grantedAuthority;

    //获得用户的授权信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthority;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
