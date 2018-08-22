package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder enc= new BCryptPasswordEncoder();
		String password=enc.encode("welcome1");
		System.out.println(password);

	}

}
