package com.manosoft.design;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootStandaloneApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(BootStandaloneApplication.class, args);
		System.out.println("Starting Standalone Application");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Standalone App");
	}
}
