package com.wjl.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.wjl.hello_service_api.HelloService;

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService{

}
