package org.example.minutes.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class MinutesException extends RuntimeException {

	public MinutesException() {
	}
	
	public MinutesException(String message) {
		super(message);
	}
	
}
