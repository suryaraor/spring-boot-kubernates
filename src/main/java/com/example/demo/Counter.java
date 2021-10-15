package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class Counter {
	@Autowired
	private ServletContext servletContext;

	public Integer getCount() {
		Integer counter = (Integer) servletContext.getAttribute("counter");
		if (counter == null) {
			counter = 0;

		}
		servletContext.setAttribute("counter", ++counter);
		
		return counter;
	}
	
	
	public Integer getSessionCount() {
		Integer counter = (Integer) session().getAttribute("counter");
		if (counter == null) {
			counter = 0;

		}
		 session().setAttribute("counter", ++counter);
		
		return counter;
	}
	// example usage
	public static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
}
