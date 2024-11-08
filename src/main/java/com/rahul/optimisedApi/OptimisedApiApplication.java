package com.rahul.optimisedApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OptimisedApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimisedApiApplication.class, args);
	}

}
