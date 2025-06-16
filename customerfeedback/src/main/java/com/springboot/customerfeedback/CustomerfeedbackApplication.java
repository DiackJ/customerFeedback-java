package com.springboot.customerfeedback;

import com.springboot.customerfeedback.Config.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerfeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerfeedbackApplication.class, args);

		SpringApplication app = new SpringApplication(CustomerfeedbackApplication.class);
		app.addInitializers(new EnvLoader());
		app.run(args);
	}

}
