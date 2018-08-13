package com.stanrnd.excel.builder;

import com.stanrnd.excel.Sheet;
import com.stanrnd.excel.exception.ExcelBuilderException;

/**
 * 
 * @author Stalin
 *
 */
public interface ExcelBuilder {
	
	public byte[] build(Sheet[] sheets) throws ExcelBuilderException;

}
