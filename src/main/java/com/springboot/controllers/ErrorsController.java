package com.springboot.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController implements ErrorController {

	Logger logger = LoggerFactory.getLogger(ErrorsController.class);
	
	@GetMapping("/errors")
	public String handleError(HttpServletRequest request) {
		logger.warn("ErrorsController is warning that...");
    
    Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Object statusName = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
    
    if (statusCode != null) {
    	Integer statusCodeInt = Integer.valueOf(statusCode.toString());
    	logger.warn("...an error has happened. Type: " + statusCode + " " + statusName + " " + HttpStatus.NOT_FOUND.getReasonPhrase());
    	if (statusCodeInt == HttpStatus.NOT_FOUND.value()) {
    		return "error/404";
    	} else if (statusCodeInt == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
    		return "errors";
    	}
    }
    			
		return "errors";
	}
}
