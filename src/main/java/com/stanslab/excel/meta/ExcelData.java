package com.stanslab.excel.meta;

import com.stanslab.excel.annotation.Data;
import com.stanslab.excel.pojo.parser.ValueParser;

public class ExcelData extends ExcelStyle {
	
	private ValueParser valueParser;
	
	public ExcelData() {
		
	}

	public ExcelData(Data data, ValueParser valueParser) {
		this.valueParser = valueParser;
		this.background = data.background();
		this.bold = data.bold();
		this.fontName = data.fontName();
		this.fontSize = data.fontSize();
		this.foreground = data.foreground();
		this.height = data.height();
		this.italic = data.italic();
		this.underline = data.underline();
	}

	public ValueParser getValueParser() {
		return valueParser;
	}

	public void setValueParser(ValueParser valueParser) {
		this.valueParser = valueParser;
	}
	
}
