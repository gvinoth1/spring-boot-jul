package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	EmpDao dao;

	public String addEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}

	public void searchEmpDetails(int empid) {
		Emp e = dao.findById(empid);
		System.out.println("Emp Details : " + e.getName() + " " + e.getCity() + " " + e.getSalary());
	}

	public void saveGroup(List<Emp> empList) {
		String resp = dao.saveBatch(empList);
		System.out.println(resp);
	}
}
