package com.stanrnd.excel.meta;

import com.stanrnd.excel.annotation.Title;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelTitle extends ExcelStyle {
	
	private String text;
	
	public ExcelTitle() {
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

	public ExcelTitle(Title title) {
		this.text = title.value();
		this.fillForeground = title.fillForeground();
		this.fillBackground = title.fillBackground();
		this.fillPattern = title.fillPattern();
		this.bold = title.bold();
		this.fontName = title.fontName();
		this.fontSize = title.fontSize();
		this.fontColor = title.fontColor();
		this.height = title.height();
		this.italic = title.italic();
		this.underline = title.underline();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
