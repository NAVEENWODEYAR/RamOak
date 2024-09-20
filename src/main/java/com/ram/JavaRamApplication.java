package com.ram;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "ASFALEA[ασφάλεια,Greek]~~[SECURITY]",
				version = "1.0",
				description = "Spring Boot demo project for spring_security,",
				termsOfService = "http://terms.example.com",
				contact = @Contact(
						name = "Naveen K Wodeyar",
						email = "naveen.wodeyar@yahoo.com",
						url = "http://naveenwodeyar.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = {
				@Server(
						url = "http://localhost:8071",
						description = "Testing server",
						variables = {
								@ServerVariable(
										name = "port",
										description = "Port number",
										defaultValue = "7070"
								)
						}
				),
				@Server(
						url = "http://production-server.com",
						description = "Production server"
				)
		},
		externalDocs = @ExternalDocumentation(
				description = "Find more info here",
				url = "http://example.com/docs"
		),
		security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT"
)
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
