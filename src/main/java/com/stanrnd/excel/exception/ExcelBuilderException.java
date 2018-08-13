package com.stanrnd.excel.exception;

public class ExcelBuilderException extends ExcelException {

	private static final long serialVersionUID = 1L;

	public ExcelBuilderException(String message) {
		super(message);
	}
	
	public ExcelBuilderException(Throwable throwable) {
		super(throwable);
	}
	
	public ExcelBuilderException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
