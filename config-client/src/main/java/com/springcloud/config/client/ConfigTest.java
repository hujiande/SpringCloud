package com.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTest {
	
	@Value("${info.profile}")
	private String profile;

	@GetMapping("/test")
	public void Test(){
		System.out.println(profile);
	}
}
