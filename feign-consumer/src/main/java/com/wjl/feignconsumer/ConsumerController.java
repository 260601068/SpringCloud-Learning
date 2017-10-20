package com.wjl.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	@Autowired
	HelloService helloService;
	
	@Autowired
	RefactorHelloService refactorHelloService;
	
	@RequestMapping("/feign-consumer")
	public String helloConsumer(){
		return helloService.hello();
	}
	
	@RequestMapping("/feign-consumer2")
	public String helloConsumer2(){
		StringBuilder sb=new StringBuilder();
		sb.append(helloService.hello()).append("|");
		sb.append(helloService.hello("DIDI")).append("|");
		sb.append(helloService.hello("DIDI",30)).append("|");
		sb.append(helloService.hello(new User("DIDI",30))).append("|");
		return sb.toString();
	}
	
	@RequestMapping("/feign-consumer3")
	public String helloConsumer3(){
		StringBuilder sb=new StringBuilder();
		sb.append(refactorHelloService.hello("MIMI")).append("|");
		sb.append(refactorHelloService.hello("MIMI",30)).append("|");
		sb.append(refactorHelloService.hello(new com.wjl.hello_service_api.User("MIMI",30))).append("|");
		return sb.toString();
	}

}
