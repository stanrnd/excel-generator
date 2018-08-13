package com.stanrnd.excel.exception;

public class ExcelException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcelException(String message) {
		super(message);
	}
	
	public ExcelException(Throwable throwable) {
		super(throwable);
	}
	
	public ExcelException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
