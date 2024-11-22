package com.example.passanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PassangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassangerApplication.class, args);
	}

}
