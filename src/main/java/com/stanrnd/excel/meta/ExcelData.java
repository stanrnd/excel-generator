package com.stanrnd.excel.meta;

import com.stanrnd.excel.annotation.Data;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelData extends ExcelStyle {
	
	public ExcelData() {
		
	}

	public ExcelData(Data data) {
		this.background = data.background();
		this.bold = data.bold();
		this.fontName = data.fontName();
		this.fontSize = data.fontSize();
		this.foreground = data.foreground();
		this.height = data.height();
		this.italic = data.italic();
		this.underline = data.underline();
	}
	
}
