package com.stanslab.excel.pojo.parser;

import java.lang.reflect.Field;

/**
 * 
 * @author Stalin
 *
 */
public class FieldValueParser implements ValueParser {
	
	private Field field;

	public FieldValueParser(Field field) {
		this.field = field;
	}

	@Override
	public Object parse(Object object) {
		try {
			return field.get(object);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
