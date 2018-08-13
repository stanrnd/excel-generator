package com.stanrnd.excel.exception;

public class ExcelInitializationException extends ExcelException {

	private static final long serialVersionUID = 1L;

	public ExcelInitializationException(String message) {
		super(message);
	}
	
	public ExcelInitializationException(Throwable throwable) {
		super(throwable);
	}
	
	public ExcelInitializationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
