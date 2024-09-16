package com.ram;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaRamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRamApplication.class, args);
		System.out.println("Jai Sri Ram.,");
	}
	
	@Bean
	public CommandLineRunner printJavaVersion() {
		return args -> {
			String javaVersion = System.getProperty("java.version");
			System.out.println("\n#############################\n");
			System.out.println("JAVA VERSION: " + javaVersion);
			System.out.println("\n#############################\n");
		};
	}


}
