package com.stanslab.excel.parser.bean;

import java.lang.reflect.Method;

/**
 * 
 * @author Stalin
 *
 */
public class MethodValueParser implements ValueParser {
	
	private Method method;

	public MethodValueParser(Method method) {
		this.method = method;
	}

	@Override
	public Object parse(Object object) {
		try {
			return method.invoke(object);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
