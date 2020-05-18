package com.example.brauctiongr2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableScheduling

public class BrAuctionGr2Application {

	public static void main(String[] args) {
		SpringApplication.run(BrAuctionGr2Application.class, args);
	}
}
