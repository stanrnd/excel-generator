package com.stanslab.excel.annotation;

public @interface ExcelColumn {

	public String value();
	
	public int width() default 300;
	
}
