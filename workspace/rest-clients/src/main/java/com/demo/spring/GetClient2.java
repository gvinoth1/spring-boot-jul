package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient2 {

	public static void main(String[] args) {
		
		String clearTextCredentials="pavan:welcome1";
		String encryptedData=new String(Base64.encodeBase64(clearTextCredentials.getBytes()));
		System.out.println("Auth Data :"+encryptedData);
		
		RestTemplate rt= new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+encryptedData);
		
		HttpEntity he=new HttpEntity<>(headers);

	ResponseEntity<String> resp=rt.exchange("http://localhost:8080/empapp/app/emp?empid=104", 
			HttpMethod.GET, he, String.class);
	
	System.out.println(resp.getBody());
	}

}
