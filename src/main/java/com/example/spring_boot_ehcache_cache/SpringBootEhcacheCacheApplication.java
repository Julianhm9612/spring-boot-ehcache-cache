package com.example.spring_boot_ehcache_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootEhcacheCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEhcacheCacheApplication.class, args);
	}

}
