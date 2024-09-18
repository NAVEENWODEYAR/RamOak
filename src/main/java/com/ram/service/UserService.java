package com.ram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.entity.UserInfo;
import com.ram.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
	
    @Autowired
    private UserRepo userInfoRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
    }
    
    public String addUser(UserInfo userInfo){
        userInfo.setUserPassword(passwordEncoder.encode(userInfo.getUserPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
    
    public List<UserInfo> getAllUser(){
         return userInfoRepository.findAll();
    }
    
    public UserInfo getUser(Integer id){
        return userInfoRepository.findById(id).get();
    }
}