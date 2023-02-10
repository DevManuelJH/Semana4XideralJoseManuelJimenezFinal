package com.manuelcodigo.crudproyectosxideral.rest;

public class DesarrolladorNotFoundException extends RuntimeException {

	public DesarrolladorNotFoundException() {
	}

	public DesarrolladorNotFoundException(String message) {
		super(message);
	}

	public DesarrolladorNotFoundException(Throwable cause) {
		super(cause);
	}

	public DesarrolladorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DesarrolladorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
