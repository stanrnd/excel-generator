package com.stanrnd.excel.annotation;

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
public @interface Column {

	public int width() default 0;
	
	public int order() default 0;
	
	public Header header() default @Header;
	
	public Data data() default @Data;
	
}
