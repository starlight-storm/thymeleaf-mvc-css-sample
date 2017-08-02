package sample.customer.ui.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import sample.common.exception.DataNotFoundException;

@ControllerAdvice
@Slf4j
public class CustomerExceptionHandler {
	
	@Autowired
    private MessageSource messageSource;
	
	@ExceptionHandler(DataNotFoundException.class)
	public String notFoundException(Locale locale) {
		log.error("*** " + messageSource.getMessage("error.notfound", null, locale) + "***");
		return "/customer/notfound";
	}
}