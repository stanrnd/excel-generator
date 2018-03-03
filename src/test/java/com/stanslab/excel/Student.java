package com.stanslab.excel;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelRow;

@ExcelRow()
public class Student {
	
	@ExcelColumn(value = "Name")
	private String name;

}
