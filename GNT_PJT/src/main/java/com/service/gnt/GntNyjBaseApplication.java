package com.service.gnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GntNyjBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GntNyjBaseApplication.class, args);
	}

}
