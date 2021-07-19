package com.example.provaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
@ComponentScan(basePackages = { "*"})
public class ProvaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaApiApplication.class, args);
	}

}
