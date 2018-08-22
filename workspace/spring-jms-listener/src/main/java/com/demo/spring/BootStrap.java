package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);

		System.out.println("Message Listener Started..");
	}

}
