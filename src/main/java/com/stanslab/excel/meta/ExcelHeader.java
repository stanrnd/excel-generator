package com.stanslab.excel.meta;

import com.stanslab.excel.annotation.Header;

public class ExcelHeader extends ExcelStyle {
	
	private String text;
	
	public ExcelHeader() {
		
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
