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
public enum ExcelType {
	
	XLS(new XLSExcelBuilder()), XLSX(new XLSXExcelBuilder()), CSV(new CSVExcelBuilder());

	private ExcelBuilder excelBuilder;
	
	private ExcelType(ExcelBuilder excelBuilder) {
		this.excelBuilder = excelBuilder;
	}
	
	public ExcelBuilder getExcelBuilder() {
		
		return excelBuilder;
	}
	
}
