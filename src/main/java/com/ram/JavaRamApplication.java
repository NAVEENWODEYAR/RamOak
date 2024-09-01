package com.ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaRamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRamApplication.class, args);
		System.out.println("Jai Sri Ram.,");
	}

}
