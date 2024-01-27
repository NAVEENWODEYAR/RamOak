package com.ram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.entity.UserInfo;
import com.ram.repo.UserRepo;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserInfo> user = userRepo.findByUserName(username);
	return user.map(UserInfoDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("User not found,"+username));
    }
    
    public String addUser(UserInfo userInfo) {
	userInfo.setUserPassword(passwordEncoder.encode(userInfo.getUserPassword()));
	userRepo.save(userInfo);
	return "User save successfully";
    }
    
    public List<UserInfo> getUsers(){
	return userRepo.findAll();
    }
    
    public UserInfo getUser(Integer userId) {
	return userRepo.findById(userId).get();
    }

   
}
