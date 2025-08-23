package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com", "com.controler"})
public class LundurySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LundurySystemApplication.class, args);
	}

}
