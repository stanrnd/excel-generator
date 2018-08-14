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
		this.foreground = Color.BLACK;
		this.background = Color.WHITE;
		this.bold = true;
		this.fontName = FontName.ARIAL;
		this.fontSize = FontSize.FIVE;
		this.height = 0;
		this.italic = false;
		this.underline = false;
	}

	public ExcelTitle(Title title) {
		this.text = title.value();
		this.background = title.background();
		this.bold = title.bold();
		this.fontName = title.fontName();
		this.fontSize = title.fontSize();
		this.foreground = title.foreground();
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
