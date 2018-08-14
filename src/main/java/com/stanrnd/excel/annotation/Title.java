package com.stanrnd.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.stanrnd.excel.meta.Color;
import com.stanrnd.excel.meta.FontName;
import com.stanrnd.excel.meta.FontSize;

/**
 * 
 * @author Stalin
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Title {
	
	public String value() default "";
	
	public int height() default 350;
	
	public Color foreground() default Color.BLACK;
	
	public Color background() default Color.WHITE;
	
	public FontName fontName() default FontName.ARIAL;
	
	public FontSize fontSize() default FontSize.FIVE;
	
	public boolean italic() default false;
	
	public boolean bold() default true;
	
	public boolean underline() default false;
	
}
