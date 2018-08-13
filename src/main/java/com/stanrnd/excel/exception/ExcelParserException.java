package com.stanrnd.excel.exception;

public class ExcelParserException extends ExcelException {

	private static final long serialVersionUID = 1L;

	public ExcelParserException(String message) {
		super(message);
	}
	
	public ExcelParserException(Throwable throwable) {
		super(throwable);
	}
	
	public ExcelParserException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
