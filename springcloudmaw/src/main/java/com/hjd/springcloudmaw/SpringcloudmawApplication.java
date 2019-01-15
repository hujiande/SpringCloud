package com.hjd.springcloudmaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudmawApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudmawApplication.class, args);
	}

} 

