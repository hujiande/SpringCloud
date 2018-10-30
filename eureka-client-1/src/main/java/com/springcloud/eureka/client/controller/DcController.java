package com.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DcController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/dc")
    public String dc() throws InterruptedException {
//		Thread.sleep(15000);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
//		throw new RuntimeException();
        return services;
    }
}
