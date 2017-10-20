package com.wjl.springinitializr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wjl.springinitializr.beans.User;

@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient client;
	@RequestMapping("/hello")
	public String myhello() throws InterruptedException{
		ServiceInstance instance=client.getLocalServiceInstance();
//		Thread.sleep(100);
		System.out.println("host: "+instance.getHost()+"  serviceId: "+instance.getServiceId());
		return "hello world";
	}
	@RequestMapping("/hello1")
	public String hello(@RequestParam String name){
		return "Hello "+name;
	}
	@RequestMapping("/hello2")
	public User hello(@RequestHeader String name,@RequestHeader Integer age){
		return new User(name,age);
	}
	@RequestMapping("/hello3")
	public String hello(@RequestBody User user){
		return "Hello "+user.getName()+", "+user.getAge();
	}
}
