package com.spring.cloud.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.es.service.HelloService;

@RestController
public class ConsumerController {
	
//	@Autowired
//	private RestTemplate template;
//	@RequestMapping("/ribbon-consumer")
//	public String hello(){
//		String str=template.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody()+" ,I'am ribbon2 !";
//		return str;
//	}
	
	@Autowired
	private HelloService helloService;
	@RequestMapping("/ribbon-consumer")
	public String hello(){
		return helloService.helloService();
	}
	
}
