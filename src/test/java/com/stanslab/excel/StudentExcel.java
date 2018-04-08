package com.stanslab.excel;

import com.stanslab.excel.annotation.Excel;
import com.stanslab.excel.annotation.ExcelSheet;
import com.stanslab.excel.meta.ExcelSheet;

@Excel("student-excel")
public class StudentExcel {
	
	@ExcelSheet(type = Student.class)
	public ExcelSheet getStudentDetailsSheet() {
		ExcelSheet sheet = new ExcelSheet();
		
		return sheet;
	}
	
	@ExcelSheet(type = Student.class)
	public ExcelSheet getMarkSheet() {
		
		return null;
	}
	
	

}
