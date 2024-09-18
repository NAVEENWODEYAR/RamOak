package com.ram;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaRamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRamApplication.class, args);
		System.out.println("\nJai Sri Ram.,\n");
		
		 try {
	            Map<Object, Object> properties = System.getProperties()
	                    .entrySet()
	                    .stream()
	                    .filter(entry -> entry.getKey().equals("java.version") || entry.getKey().equals("java.home") || entry.getKey().equals("os.name"))
	                    .collect(java.util.stream.Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	            System.out.println("\n#############################\n");
	            properties.forEach((key, value) -> System.out.println(key + ": " + value));
	            System.out.println("\n#############################\n");
	        } catch (Exception e) {
	            System.err.println("Error retrieving Java version information: " + e.getMessage());
	        }
	    }

}
