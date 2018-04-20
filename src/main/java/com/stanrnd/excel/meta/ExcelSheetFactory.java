package com.stanrnd.excel.meta;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.stanrnd.excel.parser.AnnotationExcelSheetParser;
import com.stanrnd.excel.parser.XmlExcelSheetParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelSheetFactory {
	
	private static ConcurrentMap<Class<?>, ExcelSheet> sheets = new ConcurrentHashMap<>();
	
	static {
		sheets.putAll(XmlExcelSheetParser.parse());
	}
	
	public static ExcelSheet get(Class<?> clazz) {
		if(sheets.containsKey(clazz)) {
			return sheets.get(clazz);
		}
		
		ExcelSheet excelSheet = AnnotationExcelSheetParser.parse(clazz);
		sheets.put(clazz, excelSheet);
		
		return excelSheet;
	}

}
