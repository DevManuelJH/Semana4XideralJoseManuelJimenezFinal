package com.manuelcodigo.crudproyectosxideral.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DesarrolladorRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<DesarrolladorErrorResponse> handleException(DesarrolladorNotFoundException exc) {
		
		
		DesarrolladorErrorResponse error = new DesarrolladorErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler
	public ResponseEntity<DesarrolladorErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		DesarrolladorErrorResponse error = new DesarrolladorErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





