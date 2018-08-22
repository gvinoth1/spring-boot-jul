package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {

	public static void main(String[] args) {
		RestTemplate rt= new RestTemplate();
	ResponseEntity<String> resp=	rt.getForEntity("http://localhost:8080/empapp/emp?empid=104",
																					String.class);

	System.out.println(resp.getBody());
	}

}
