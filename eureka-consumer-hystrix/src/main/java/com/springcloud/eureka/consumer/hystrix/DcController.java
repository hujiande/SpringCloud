package com.springcloud.eureka.consumer.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc() throws Exception {
		
		String execute = consumerService.execute();						//延迟的服务降级
		return execute;
		
	}
}
