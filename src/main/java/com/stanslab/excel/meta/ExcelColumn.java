package com.stanslab.excel.meta;

import com.stanslab.excel.annotation.Column;
import com.stanslab.excel.parser.bean.ValueParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelColumn {
	
	private int width;
	
	private int order;
	
	private ExcelHeader header;
	
	private ExcelData data;
	
	private ValueParser valueParser;
	
	public ExcelColumn() {
		
	}

	public ExcelColumn(Column column, ValueParser valueParser) {
		this.width = column.width();
		this.order = column.order();
		this.header = new ExcelHeader(column.header());
		this.data = new ExcelData(column.data());
		this.valueParser = valueParser;
	}

	public ExcelHeader getHeader() {
		return header;
	}

	public void setHeader(ExcelHeader header) {
		this.header = header;
	}

	public ExcelData getData() {
		return data;
	}

	public void setData(ExcelData data) {
		this.data = data;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public ValueParser getValueParser() {
		return valueParser;
	}

	public void setValueParser(ValueParser valueParser) {
		this.valueParser = valueParser;
	}

}
