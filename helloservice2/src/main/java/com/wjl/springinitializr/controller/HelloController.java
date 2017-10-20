package com.wjl.springinitializr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
