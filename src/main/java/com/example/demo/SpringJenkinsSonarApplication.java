package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringJenkinsSonarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJenkinsSonarApplication.class, args);
	}
	@GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }

}
