package com.spring.cloud.es.service;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.spring.cloud.es.bean.User;
public class HelloCommand extends HystrixCommand<User> {
	private RestTemplate restTemplate;
	private Long id;
	protected HelloCommand(com.netflix.hystrix.HystrixCommand.Setter setter,RestTemplate restTemplate,Long id) {
		super(setter);
		this.restTemplate=restTemplate;
		this.id=id;
	}
	@Override
	protected User run() throws Exception {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello/{1}",User.class,id);
	}
	
	
}
