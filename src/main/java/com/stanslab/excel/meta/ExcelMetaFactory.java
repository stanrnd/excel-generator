package com.stanslab.excel.meta;

import java.util.HashMap;
import java.util.Map;

import com.stanslab.excel.meta.parser.ExcelMetaParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelMetaFactory {
	
	private static Map<Class<?>, ExcelMeta> metas = new HashMap<>();
	
	
	public static ExcelMeta get(Class<?> clazz) {
		if(metas.containsKey(clazz)) {
			return metas.get(clazz);
		}
		
		ExcelMeta excelMeta;
		metas.put(clazz, excelMeta = ExcelMetaParser.parseExcelMeta(clazz));
		
		return excelMeta;
	}

}
