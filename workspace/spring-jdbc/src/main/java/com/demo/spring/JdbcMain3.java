package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

public class JdbcMain3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService service= ctx.getBean(HrService.class);
		
		//service.searchEmpDetails(1044);
		
		//service.addEmployee(109, "James", "Scottland", 56000);
		
		List<Emp> emps=new ArrayList<>();
		emps.add(new Emp(118, "Kirthi", "Hyderabad", 45000));
		emps.add(new Emp(119, "Kamal", "Hyderabad", 55000));
		emps.add(new Emp(110, "Amith", "Hyderabad", 65000));
		emps.add(new Emp(121, "Raja", "Hyderabad", 75000));
		
		service.saveGroup(emps);

	}

}
