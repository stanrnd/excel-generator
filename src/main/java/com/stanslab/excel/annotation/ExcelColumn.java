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
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

	public String value();

	public int width() default -1;
	
	public int order() default 0;

	final public static ExcelColumn DEFAULT = new ExcelColumn() {
		
		@Override
		public Class<? extends Annotation> annotationType() {
			return null;
		}
		
		@Override
		public int width() {
			return -1;
		}
		
		@Override
		public int order() {
			return 0;
		}
		
		@Override
		public String value() {
			return "";
		}

	};
	
}
