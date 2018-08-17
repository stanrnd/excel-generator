package com.stanrnd.excel.meta;

import com.stanrnd.excel.annotation.Header;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelHeader extends ExcelStyle {
	
	private String text;
	
	public ExcelHeader() {
		this.text = "";
		this.fillForeground = Color.BLACK;
		this.fillBackground = Color.WHITE;
		this.fillPattern = FillPattern.NO_FILL;
		this.bold = true;
		this.fontName = "Calibri";
		this.fontSize = FontSize.EIGHT;
		this.fontColor = Color.BLACK;
		this.height = 0;
		this.italic = false;
		this.underline = 0;
	}

	public ExcelHeader(Header header) {
		this.text = header.value();
		this.fillForeground = header.fillForeground();
		this.fillBackground = header.fillBackground();
		this.fillPattern = header.fillPattern();
		this.bold = header.bold();
		this.fontName = header.fontName();
		this.fontSize = header.fontSize();
		this.fontColor = header.fontColor();
		this.height = header.height();
		this.italic = header.italic();
		this.underline = header.underline();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
