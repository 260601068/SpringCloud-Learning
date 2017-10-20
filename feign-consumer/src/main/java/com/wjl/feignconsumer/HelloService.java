package com.wjl.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//此处的服务名必须大写，小写只能默认识别8080端口的服务
@FeignClient(name="HELLO-SERVICE",fallback=HelloServiceFallback.class)
public interface HelloService {
	
	@RequestMapping("/hello")
	String hello();
	//@RequestParam和@RequestHeader注解中的value值必须写，此处不同于springmvc
	@RequestMapping("/hello1")
	String hello(@RequestParam("name") String name);
	
	@RequestMapping("/hello2")
	User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	
	@RequestMapping("/hello3")
	String hello(@RequestBody User user);
}
