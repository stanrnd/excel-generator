package com.stanslab.excel;

import com.stanslab.excel.builder.ExcelBuilder;
import com.stanslab.excel.builder.CSVExcelBuilder;
import com.stanslab.excel.builder.XLSExcelBuilder;
import com.stanslab.excel.builder.XLSXExcelBuilder;

/**
 * 
 * @author Stalin
 *
 */
public enum Type {
	
	XLS(new XLSExcelBuilder()), XLSX(new XLSXExcelBuilder()), CSV(new CSVExcelBuilder());

	private ExcelBuilder excelBuilder;
	
	private Type(ExcelBuilder excelBuilder) {
		this.excelBuilder = excelBuilder;
	}
	
	public ExcelBuilder getExcelBuilder() {
		
		return excelBuilder;
	}
	
}
