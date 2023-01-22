package com.example.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class SnyApplication {
	@GetMapping("/run")
	public String first(){
		return "Deployed";
	}
	public static void main(String[] args) {
		SpringApplication.run(SnyApplication.class, args);
	}

}
