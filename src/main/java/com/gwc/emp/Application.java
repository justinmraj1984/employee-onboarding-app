package com.gwc.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// bootstraps a spring application as a stand-alone application from the main method.
		SpringApplication.run(Application.class, args);
	}

}
