package com.stanrnd.excel.meta;

import com.stanrnd.excel.annotation.Data;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelData extends ExcelStyle {
	
	public ExcelData() {
		this.fillForeground = Color.BLACK;
		this.fillBackground = Color.WHITE;
		this.fillPattern = FillPattern.NO_FILL;
		this.bold = false;
		this.fontName = "Calibri";
		this.fontSize = FontSize.EIGHT;
		this.fontColor = Color.BLACK;
		this.height = 0;
		this.italic = false;
		this.underline = 0;
	}

	public ExcelData(Data data) {
		this.fillForeground = data.fillForeground();
		this.fillBackground = data.fillBackground();
		this.fillPattern = data.fillPattern();
		this.bold = data.bold();
		this.fontName = data.fontName();
		this.fontSize = data.fontSize();
		this.fontColor = data.fontColor();
		this.height = data.height();
		this.italic = data.italic();
		this.underline = data.underline();
	}
	
}
