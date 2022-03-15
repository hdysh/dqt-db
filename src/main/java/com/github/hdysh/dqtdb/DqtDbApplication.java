package com.github.hdysh.dqtdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DqtDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DqtDbApplication.class, args);
	}
}
