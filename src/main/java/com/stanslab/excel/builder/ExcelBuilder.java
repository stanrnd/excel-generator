package com.stanslab.excel.builder;

import com.stanslab.excel.Sheet;

/**
 * 
 * @author Stalin
 *
 */
public interface ExcelBuilder {
	
	public byte[] build(Sheet[] sheets);

}
