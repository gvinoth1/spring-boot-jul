package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HrRestController {
	@Autowired
	HrService hr;

	@GetMapping(path = "/hr/search/{id}", produces = "application/json")
	public ResponseEntity processSearch(@PathVariable("id") int id) {
		return hr.searcEmp(id);
	}

	@GetMapping(path = "/hr/listAll", produces = "application/json")
	public ResponseEntity processList() {
		return hr.listEmps();
	}
}
