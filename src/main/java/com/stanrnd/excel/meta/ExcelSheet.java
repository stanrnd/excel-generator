package com.stanrnd.excel.meta;

import java.util.List;

import com.stanrnd.excel.annotation.Sheet;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelSheet {
	
	private String name;
	
	private ExcelTitle title;
	
	private List<ExcelColumn> columns;
	
	public ExcelSheet(String name) {
		this.name = name;
	}

	public ExcelSheet(Sheet sheet) {
		this.name = sheet.value();
		this.title = new ExcelTitle(sheet.title());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExcelTitle getTitle() {
		return title;
	}

	public void setTitle(ExcelTitle title) {
		this.title = title;
	}

	public List<ExcelColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<ExcelColumn> columns) {
		this.columns = columns;
	}
	
}
