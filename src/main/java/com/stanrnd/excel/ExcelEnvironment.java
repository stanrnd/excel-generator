package com.stanrnd.excel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.stanrnd.excel.exception.ExcelException;
import com.stanrnd.excel.exception.ExcelInitializationException;
import com.stanrnd.excel.meta.ExcelSheet;
import com.stanrnd.excel.parser.AnnotationExcelSheetParser;
import com.stanrnd.excel.parser.XmlExcelSheetParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelEnvironment {
	
	private static ConcurrentMap<Class<?>, ExcelSheet> sheets;
	
	public static void init() throws ExcelInitializationException {
		try {
			sheets = new ConcurrentHashMap<>();
			sheets.putAll(XmlExcelSheetParser.parse());
		} catch (ExcelException e) {
			throw new ExcelInitializationException(e);
		}
	}
	
	public static boolean isInited() {

		return sheets != null;
	}
	
	public static ExcelSheet getSheet(Class<?> clazz) throws ExcelException {
		if(sheets == null) {
			throw new ExcelInitializationException("Excel environment not initialized.");
		}
		if(sheets.containsKey(clazz)) {
			return sheets.get(clazz);
		}
		
		ExcelSheet excelSheet = AnnotationExcelSheetParser.parse(clazz);
		sheets.put(clazz, excelSheet);
		
		return excelSheet;
	}

}
