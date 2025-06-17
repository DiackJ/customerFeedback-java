package com.springboot.customerfeedback;

import com.springboot.customerfeedback.Config.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class CustomerfeedbackApplication {

	static{
		EnvLoader.loader();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerfeedbackApplication.class, args);
	}

}
