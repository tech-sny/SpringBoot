package com.example.Spring.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class SpringAppApplication {

	@GetMapping("/run")
	public String firstFunction(){
		return "Deployed";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
		
	}

}
