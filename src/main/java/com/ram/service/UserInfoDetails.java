package com.ram.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ram.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDetails implements UserDetails {

    private String userName=null;
    private String userPassword=null;
    List<GrantedAuthority> authorities;
    
    public UserInfoDetails(UserInfo userInfo) {
	this.userName = userInfo.getUserName();
	this.userPassword = userInfo.getUserPassword();
	authorities = Arrays.stream(userInfo.getUserRoles().split(" "))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getPassword() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getUsername() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
    }

}
