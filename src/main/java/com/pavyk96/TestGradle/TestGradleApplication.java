package com.pavyk96.TestGradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGradleApplication.class, args);
	}

}
