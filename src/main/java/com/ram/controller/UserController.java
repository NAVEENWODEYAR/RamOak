package com.ram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.ram.entity.AuthRequest;
import com.ram.entity.UserInfo;
import com.ram.service.JwtService;
import com.ram.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userInfoService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/welcome")
	@ResponseStatus(code = HttpStatus.FOUND)
	public String welcome() {
		return "Jai Sri Ram.,";
	}

	@GetMapping("/jwt")
	@ResponseStatus(code = HttpStatus.OK)
	public String greetMsg() {
		return "Json Web Token,";
	}

	@PostMapping("/addUser")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String addUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo);

	}

	@PostMapping("/login")
	@ResponseStatus(code = HttpStatus.CONTINUE)
	public String addUser(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}

	@GetMapping("/getUsers")
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<UserInfo> getAllUsers() {
		return userInfoService.getAllUser();
	}

	@GetMapping("/getUsers/{id}")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public UserInfo getAllUsers(@PathVariable Integer id) {
		return userInfoService.getUser(id);
	}
}