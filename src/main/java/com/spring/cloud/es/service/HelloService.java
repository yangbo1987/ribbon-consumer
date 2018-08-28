package com.spring.cloud.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService(){
		System.out.println("执行hello-service");
		String str=restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody()+" ,I'am ribbon +hystrix !";
		return str;
	}
	
	public String helloFallback(){
		return "error";
	}
}
