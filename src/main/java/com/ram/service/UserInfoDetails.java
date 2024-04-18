package com.ram.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ram.entity.UserInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 2984506556402628467L;
    String userName=null;
    String password = null;
    List<GrantedAuthority> authorities;

    public UserInfoDetails(UserInfo userInfo){
       userName= userInfo.getUserName();
       password= userInfo.getUserPassword();
       authorities= Arrays.stream(userInfo.getUserRoles().split(","))
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
