package com.demo.giftmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.demo",
		"com.sug.core.platform.web"
})
public class GiftmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftmoneyApplication.class, args);
	}

}

