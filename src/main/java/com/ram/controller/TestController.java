package com.ram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NaveenWodeyar
 * @date 20-Sept-2024
 */

@RestController
@RequestMapping("/v1")
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@GetMapping
	public String test() {
		log.info("test endpoint accessed,,");
System.out.println("\n##############/n");
		return "connected,,";
	}
}
