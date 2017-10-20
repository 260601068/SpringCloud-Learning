package com.wjl.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

import zipkin.server.EnableZipkinServer;

//@EnableZipkinServer		//直接通过http访问zipkin server
@EnableZipkinStreamServer		//经过rabbitmq传递跟踪信息访问zipkin server
@SpringBootApplication
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
