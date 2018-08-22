package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	@Override
	public void perform() throws PerformerException {
		try {
			//throw new PerformerException();
			System.out.println("Singer is now singing the song...");
		} catch (Exception e) {
			System.out.println("In catch block..");
			e.printStackTrace();
			
			throw e;
		} finally {
			System.out.println("In finally block.");
		}
	}

}
