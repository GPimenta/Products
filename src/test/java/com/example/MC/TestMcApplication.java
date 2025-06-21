package com.example.MC;

import org.springframework.boot.SpringApplication;

public class TestMcApplication {

	public static void main(String[] args) {
		SpringApplication.from(McApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
