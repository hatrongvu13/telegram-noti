package com.xxx.telegramnoti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramNotiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramNotiApplication.class, args);
	}

}
