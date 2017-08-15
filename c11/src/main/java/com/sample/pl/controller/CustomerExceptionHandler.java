package com.sample.pl.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sample.exception.DataNotFoundException;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerExceptionHandler.class);
	
	@Autowired
    private MessageSource messageSource;
	
	@ExceptionHandler(DataNotFoundException.class)
	public String notFoundException(Locale locale) {
		logger.error("*** " + messageSource.getMessage("error.notfound", null, locale) + "***");
		return "/customer/notfound";
	}
}