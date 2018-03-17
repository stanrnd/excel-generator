package com.stanslab.excel.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Stalin
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelRow {
	
	public short height() default 20;

	final public static ExcelRow DEFAULT = new ExcelRow() {
		
		@Override
		public Class<? extends Annotation> annotationType() {
			return ExcelRow.class;
		}
		
		@Override
		public short height() {
			return 20;
		}
		
	};
	
}
