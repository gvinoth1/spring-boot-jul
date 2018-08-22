package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;

@Service
public class HRService {

	@Autowired
	@Qualifier("jpa")
	private EmpDao dao;
	
	public HRService() {
		
	}
	public HRService(EmpDao dao) {
		this.dao = dao;
	}

	public String addEmployee(int id, String name, String address, double salary) {
		String resp = dao.save(new Emp(id, name, address, salary));
		return resp;
	}
}
