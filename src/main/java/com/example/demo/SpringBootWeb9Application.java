package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.entity")
@ComponentScan(basePackages = {"com.example.controller"})
public class SpringBootWeb9Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeb9Application.class, args);
	}

}
