package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;

	@HystrixCommand(fallbackMethod="searchEmpDefault")
	public ResponseEntity searcEmp(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity he = new HttpEntity<>(headers);

		ResponseEntity<String> resp = rt.exchange("http://emp-service/app/emp?empid=" + id, HttpMethod.GET,
				he, String.class);
		return resp;
	}

	@HystrixCommand(fallbackMethod="listEmpDefault")
	public ResponseEntity listEmps() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity he = new HttpEntity<>(headers);

		ResponseEntity<String> resp = rt.exchange("http://emp-service/app/emplist", HttpMethod.GET,
				he, String.class);
		return resp;
	}
	
	public ResponseEntity listEmpDefault() {
		return ResponseEntity.ok("{\"status\":\"EmpList Service is Down, Try After Some Time\"}");
	}
	
	public ResponseEntity searchEmpDefault(int id) {
		return ResponseEntity.ok("{\"status\":\"EMP Search Service is Down, Try After Some Time\"}");
	}
	
}
