package com.firstSpringBootProject.firstSpringBootProject;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(

						title = "Spring Boot REST API Documentation",
						description="Spring Boot REST API Documentation",
						version = "v1.0",
						contact = @Contact(
								name = "Suresh",
								email = "suresh@gmail.com",
								url = "www."
						),
						license = @License(
								name = "Apcahe 2.0",
								url = "www."
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Documentation",
				url = "www."
		)
			)
public class FirstSpringBootProjectApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProjectApplication.class, args);

	}

}
