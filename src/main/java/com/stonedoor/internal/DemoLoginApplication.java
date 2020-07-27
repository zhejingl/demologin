package com.stonedoor.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLoginApplication.class, args);
		System.out.println("the endpoint is: /v1/api/demo/social/login");
	}

}
