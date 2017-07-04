package sample.customer.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sample.customer.biz.service.DataNotFoundException;

@ControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler(DataNotFoundException.class)
	public String notFoundException() {
		return "/customer/notfound";
	}
}