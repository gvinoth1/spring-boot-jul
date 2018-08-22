package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

	@GetMapping("/info1")
	public String info() {
		return "Spring boot demo app";
	}
}
