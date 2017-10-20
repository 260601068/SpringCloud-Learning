package com.wjl.springinitializr.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wjl.hello_service_api.HelloService;
import com.wjl.hello_service_api.User;

@RestController
public class RefacotrHelloController implements HelloService{

	@Override
	public String hello(@RequestParam("name") String name) {
		// TODO Auto-generated method stub
		return "Hello "+name;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		// TODO Auto-generated method stub
		return  new User(name,age);
	}

	@Override
	public String hello(@RequestBody User user) {
		// TODO Auto-generated method stub
		return "Hello "+user.getName()+", "+user.getAge();
	}

}
