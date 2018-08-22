package com.demo.spring;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;

public class HRService {

	private EmpDao dao;
	public HRService() {
		
	}
	public HRService(EmpDao dao) {
		this.dao = dao;
	}

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	public String addEmployee(int id, String name, String address, double salary) {
		String resp = dao.save(new Emp(id, name, address, salary));
		return resp;
	}
}
