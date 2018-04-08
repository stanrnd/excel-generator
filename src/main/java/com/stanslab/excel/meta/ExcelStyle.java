package com.stanslab.excel.meta;

abstract public class ExcelStyle {
	
	protected int height;
	
	protected Color foreground;
	
	protected Color background;
	
	protected FontName fontName;
	
	protected FontSize fontSize;
	
	protected boolean italic;
	
	protected boolean bold;
	
	protected boolean underline;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public FontName getFontName() {
		return fontName;
	}

	public void setFontName(FontName fontName) {
		this.fontName = fontName;
	}

	public FontSize getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

}
