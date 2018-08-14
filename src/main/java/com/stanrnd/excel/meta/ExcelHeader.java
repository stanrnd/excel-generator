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
		this.foreground = Color.BLACK;
		this.background = Color.WHITE;
		this.bold = true;
		this.fontName = FontName.ARIAL;
		this.fontSize = FontSize.FIVE;
		this.height = 0;
		this.italic = true;
		this.underline = false;
	}

	public ExcelHeader(Header header) {
		this.text = header.value();
		this.background = header.background();
		this.bold = header.bold();
		this.fontName = header.fontName();
		this.fontSize = header.fontSize();
		this.foreground = header.foreground();
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
