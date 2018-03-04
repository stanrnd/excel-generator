package com.stanslab.excel.annotation;

public @interface ExcelHeader {
	
	public String value();
	
	public int height() default 20;

}
