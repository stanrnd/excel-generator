package com.stanrnd.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.stanrnd.excel.meta.Color;
import com.stanrnd.excel.meta.FillPattern;
import com.stanrnd.excel.meta.FontSize;

/**
 * 
 * @author Stalin
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Data {

	public short height() default 0;
	
	public Color fillForeground() default Color.BLACK;
	
	public Color fillBackground() default Color.WHITE;
	
	public FillPattern fillPattern() default FillPattern.NO_FILL;
	
	public String fontName() default "Calibri";
	
	public FontSize fontSize() default FontSize.EIGHT;
	
	public Color fontColor() default Color.BLACK;
	
	public boolean italic() default false;
	
	public boolean bold() default false;
	
	public byte underline() default 0;
	
}
