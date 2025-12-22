package br.com.victorhugo.todolist.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError(
				Instant.now(),
				status.value(),
				"Resource not found",
				exception.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
}