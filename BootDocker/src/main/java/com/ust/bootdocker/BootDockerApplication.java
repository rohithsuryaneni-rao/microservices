package com.ust.bootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BootDockerApplication {
	
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(BootDockerApplication.class, args);
	}

}
