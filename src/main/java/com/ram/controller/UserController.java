package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ram.entity.AuthRequest;
import com.ram.entity.UserInfo;
import com.ram.service.JwtService;
import com.ram.service.UserService;


@RestController
@RequestMapping("/ram")
public class UserController {
	
    	@Autowired
    	private UserService userService;
    	@Autowired
    	private JwtService jwtService;
    	@Autowired
    	private AuthenticationManager authenticationManager;
    
	@GetMapping("/greet")
	@ResponseStatus(code = HttpStatus.FOUND)
	public String greet() {
		return "Jai Sri Ram";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserInfo userInfo) {
	    userService.addUser(userInfo);
	    return "User successfully added";
	}
	
	@PostMapping("/login")
	public String addUser(@RequestBody AuthRequest authRequest) {
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getUserPassword()));
	    if(authentication.isAuthenticated()) {
		return jwtService.generateToken(authRequest.getUserName());
	    }
	    else {
		throw new UsernameNotFoundException("Invalid user request");
	    }    
	}
	
	@GetMapping("/getUsers")
	public List<UserInfo> getAllUsers(){
	    return userService.getUsers();
	}
	
	@GetMapping("/getUser/{userId}")
	public UserInfo getUserById(@PathVariable Integer userId) {
	    return userService.getUser(userId);
	}
}
