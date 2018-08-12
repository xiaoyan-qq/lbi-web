/**************************************
 * Copyright (C), Navinfo
 * Package: com.pl.admin.model
 * Author: liumingkai05559
 * Date: Created in 2018/6/4 14:09
 **************************************/
package com.lbi.tile.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*************************************
 * Class Name: SysUser
 * Description:〈系统用户〉
 * @author liumingkai
 * @create 2018/6/4
 * @since 1.0.0
 ************************************/
@Getter
@Setter
public class SysUser implements UserDetails {
    Long id;
    String username;
    String password;
    String email;
    List<SysRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = this.getRoles();
        for (SysRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

