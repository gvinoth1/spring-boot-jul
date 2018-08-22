package com.demo.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="emp")
public class Employee {

	private int empId;
	private String name;
	private String city;
	@JsonIgnore
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, String city, double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
