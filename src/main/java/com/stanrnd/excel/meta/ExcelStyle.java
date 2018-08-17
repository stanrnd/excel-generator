package com.stanrnd.excel.meta;

/**
 * 
 * @author Stalin
 *
 */
abstract public class ExcelStyle {
	
	protected short height;
	
	protected Color fillForeground;
	
	protected Color fillBackground;
	
	protected FillPattern fillPattern;
	
	protected String fontName;
	
	protected FontSize fontSize;
	
	protected Color fontColor;
	
	protected boolean italic;
	
	protected boolean bold;
	
	protected byte underline;

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public Color getFillForeground() {
		return fillForeground;
	}

	public void setFillForeground(Color fillForeground) {
		this.fillForeground = fillForeground;
	}

	public Color getFillBackground() {
		return fillBackground;
	}

	public void setFillBackground(Color fillBackground) {
		this.fillBackground = fillBackground;
	}

	public FillPattern getFillPattern() {
		return fillPattern;
	}

	public void setFillPattern(FillPattern fillPattern) {
		this.fillPattern = fillPattern;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public FontSize getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
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

	public byte getUnderline() {
		return underline;
	}

	public void setUnderline(byte underline) {
		this.underline = underline;
	}

}
