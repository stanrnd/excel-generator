package com.stanslab.excel.meta;

import java.util.HashMap;
import java.util.Map;

import com.stanslab.excel.meta.parser.ExcelMetaParser;

/**
 * 
 * @author Stalin
 *
 */
public class SheetMetaFactory {
	
	private static Map<Class<?>, ExcelSheet> metas = new HashMap<>();
	
	
	public static ExcelSheet get(Class<?> clazz) {
		if(metas.containsKey(clazz)) {
			return metas.get(clazz);
		}
		
		ExcelSheet excelMeta;
		metas.put(clazz, excelMeta = ExcelMetaParser.parseExcelMeta(clazz));
		
		return excelMeta;
	}

}
