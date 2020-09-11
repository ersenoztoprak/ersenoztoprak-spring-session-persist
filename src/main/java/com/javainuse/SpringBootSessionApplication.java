package com.javainuse;

import com.javainuse.controller.CacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSessionApplication {

	public static void main(String[] args) {
		//CacheManager.init("redishaproxy.stage.odeal.cc", 6379);
		SpringApplication.run(SpringBootSessionApplication.class, args);
	}
	
	
}