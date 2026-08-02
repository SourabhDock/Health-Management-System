package com.medicure.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		System.out.println("backend start");
		SpringApplication.run(BackendApplication.class, args);
	}

}
