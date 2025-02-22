package com.project.bookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.project.bookmanagement")
@ComponentScan(basePackages = {"com.project.bookmanagement", "com/project/bookmanagement/config"})
public class BookmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagementApplication.class, args);
	}

}
