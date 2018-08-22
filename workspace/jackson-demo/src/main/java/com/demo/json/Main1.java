package com.demo.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main1 {

	public static void main(String[] args) throws Exception{
		Employee e1=new Employee(100, "James", "Hyderabad", 56000);
		String data=new ObjectMapper().writeValueAsString(e1);
		System.out.println(data);
	}

}
