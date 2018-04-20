package com.stanrnd.excel.parser.bean;

/**
 * 
 * @author Stalin
 *
 */
public interface ValueParser {
	
	public String name();
	
	public Object parse(Object object);

}
