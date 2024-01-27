package com.ram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ram")
@Slf4j
public class MyController {
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.FOUND)
	public String greet() {
		log.info("Jai Sri Ram");
		return "Jai Sri Ram";
	}
}
