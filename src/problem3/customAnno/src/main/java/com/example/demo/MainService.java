package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	@TrackExecutionTime
	public String getHome() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Home";
	}

	@TrackExecutionTime
	public String getContact() {
		// TODO Auto-generated method stub
		return "Contact";
	}
	
}
