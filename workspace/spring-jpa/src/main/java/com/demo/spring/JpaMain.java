package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class JpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService service = (HrService) ctx.getBean(HrService.class);

		String resp = service.addEmployee(204, "Kiran", "Hyderabad", 90000);
		System.out.println(resp);
		service.searchEmpDetails(104);

	}

}
