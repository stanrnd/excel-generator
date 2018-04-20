package com.stanrnd.excel;

import com.stanrnd.excel.builder.ExcelBuilder;
import com.stanrnd.excel.builder.CSVExcelBuilder;
import com.stanrnd.excel.builder.XLSExcelBuilder;
import com.stanrnd.excel.builder.XLSXExcelBuilder;

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
