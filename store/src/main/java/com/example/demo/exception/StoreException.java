package com.example.demo.exception;

public class StoreException extends RuntimeException{
	
	public StoreException(String message) {
		super(message);
	}
	
	public StoreException(String message, Throwable caues) {
		super(message,caues);
	}
}
