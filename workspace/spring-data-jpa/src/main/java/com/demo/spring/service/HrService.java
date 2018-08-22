package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	EmpRepository repo;

	public String addEmployee(int id, String name, String city, double salary) {
		Emp e = repo.save(new Emp(id, name, city, salary));

		return "saved";
	}

	public void searchEmpDetails(int empid) {
		Optional<Emp> o = repo.findById(empid);
		Emp e = o.get();
		System.out.println("Emp Details : " + e.getName() + " " + e.getCity() + " " + e.getSalary());
	}

	public void saveGroup(List<Emp> empList) {
		repo.saveAll(empList);
	}
}
