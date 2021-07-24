package com.springboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World!";
	}
	
	@RequestMapping(value="/exception", method=RequestMethod.GET)
  public void forceException() {
      throw new RuntimeException("Test exception!");
  }
	
	@RequestMapping("/response")
  @ResponseBody
  public String handleResponse(HttpServletRequest request) {
      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
      return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                      + "<div>Exception Message: <b>%s</b></div><body></html>",
              statusCode, exception==null? "N/A": exception.getMessage());
  }

}
