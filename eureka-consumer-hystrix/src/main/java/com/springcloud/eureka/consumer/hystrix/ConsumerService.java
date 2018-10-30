package com.springcloud.eureka.consumer.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class ConsumerService extends com.netflix.hystrix.HystrixCommand<String> {

	private String name;

	protected ConsumerService(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")) // 必须
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)) // 超时时间
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(3)));

		this.name = name;
	}

	@Autowired
	private RestTemplate restTemplate;

	@Override
	protected String run() throws InterruptedException {
		// String theadName = this.getThreadPoolKey().name();
		// String cmdKey = this.getThreadPoolKey().name();
		// System.out.println("running begin , threadPool=" + theadName + "
		// cmdKey=" + cmdKey + " name=" + name);
		//
		// if ("Exception".equals(name)) {
		// throw new RuntimeException("this command always fails");
		// } else if ("Timeout".equals(name)) {
		// TimeUnit.SECONDS.sleep(2);
		// } else if ("Reject".equals(name)) {
		// TimeUnit.MILLISECONDS.sleep(800);
		// }
		// System.out.println(" run end");
		try {
			name = restTemplate.getForObject("http://eureka-client/dc", String.class);
			System.out.println(name);
		} catch (Exception e) {
			throw new RuntimeException("!!!");
		}
		return name;
	}

	@Override
	protected String getFallback() {
		return name;
	}

}
