package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EmpZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpZuulProxyApplication.class, args);
	}
}
