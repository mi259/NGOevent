package com.ngoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ngoproject.repository")
@ComponentScan(basePackages = "com.ngoproject.services")
@ComponentScan(basePackages = "com.ngoproject.jwt")
@SpringBootApplication
public class NgOeventApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NgOeventApplication.class, args);
	}

}
