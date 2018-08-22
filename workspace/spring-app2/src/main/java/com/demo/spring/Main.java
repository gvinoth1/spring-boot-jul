package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		//ConfigurableApplicationContext ctx1 = new ClassPathXmlApplicationContext("context.xml");
		
		HRService service=(HRService)ctx.getBean("hr");
		
		String resp=service.addEmployee(100, "Charles", "England", 23000);
		System.out.println(resp);
		

	}

}
