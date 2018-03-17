package com.stanslab.excel.builder;

import java.util.List;

import com.stanslab.excel.ExcelSheet;

/**
 * 
 * @author Stalin
 *
 */
public interface ExcelBuilder {
	
	public byte[] build(List<ExcelSheet> excelSheets);

}
