package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	Environment environment;
	
	@Autowired
	Counter counter;
	
	@GetMapping("/")
	public String hello() {
		String hostAddress="";
		String hostName="";
		String remoteAddress="";
		String remoteHostName="";
		
		try {
	    	hostAddress = InetAddress.getLocalHost().getHostAddress();
			hostName = InetAddress.getLocalHost().getHostName();
	    	remoteAddress = InetAddress.getLoopbackAddress().getHostAddress();
	    	remoteHostName = InetAddress.getLoopbackAddress().getHostName();
	    } catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<br/>Host Address: <b>"+hostAddress+"</b>");
		buffer.append("<br/>Host hostName: <b>"+hostName+"</b>");
		buffer.append("<br/>Remote Address: <b>"+remoteAddress+"</b>");
		buffer.append("<br/>Remote Host Name: <b>"+remoteHostName+"</b>");
		buffer.append("<br/>Total Site Visits: <b>"+counter.getCount()+"</b>");
		buffer.append("<br/>Session Visits: <b>"+counter.getSessionCount()+"</b>");
		
	    
		return buffer.toString();
	}

}
