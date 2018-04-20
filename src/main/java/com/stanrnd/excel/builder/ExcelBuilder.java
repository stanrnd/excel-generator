package com.stanrnd.excel.builder;

import com.stanrnd.excel.Sheet;

/**
 * 
 * @author Stalin
 *
 */
public interface ExcelBuilder {
	
	public byte[] build(Sheet[] sheets);

}
