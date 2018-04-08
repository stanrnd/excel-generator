package com.stanslab.excel.meta;

import java.util.HashMap;
import java.util.Map;

import com.stanslab.excel.meta.parser.ExcelMetaParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelSheetFactory {
	
	private static Map<Class<?>, ExcelSheet> sheets = new HashMap<>();
	
	static {
		
	}
	
	public static ExcelSheet get(Class<?> clazz) {
		if(sheets.containsKey(clazz)) {
			return sheets.get(clazz);
		}
		
		ExcelSheet excelSheet = ExcelMetaParser.parseExcelMeta(clazz);
		sheets.put(clazz, excelSheet);
		
		return excelSheet;
	}

}
