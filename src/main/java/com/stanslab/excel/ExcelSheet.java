package com.stanslab.excel;

import java.util.List;

public class ExcelSheet {
	
	private String name;
	
	private String title;
	
	private Class<?> rowType;
	
	private List<?> rows;

	public ExcelSheet(String name, String title) {
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Class<?> getRowType() {
		return rowType;
	}

	public void setRowType(Class<?> rowType) {
		this.rowType = rowType;
	}

	public List<?> getRows() {
		return rows;
	}

	public <T> void setRows(List<T> rows, Class<T> rowType) {
		this.rows = rows;
		this.rowType = rowType;
	}
	
}
