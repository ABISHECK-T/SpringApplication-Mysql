package com.techfusion.cms.exception.handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleStudentNotFound(
	        EmptyResultDataAccessException exception) {

	    return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Student not found");
	}
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception exception) {
		System.out.println("Exception occured");
		return exception.getMessage();
	}
	
}
