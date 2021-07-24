package com.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(scanBasePackages = "com.springboot")
//@Configuration
//@EnableAutoConfiguration 
@ComponentScan(value = "com.springboot")
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringBootDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}