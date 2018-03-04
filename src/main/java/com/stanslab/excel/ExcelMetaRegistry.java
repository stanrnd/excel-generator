package com.stanslab.excel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelMetaRegistry {
	
	final private static Map<Class<?>, ExcelSheet> cache = new ConcurrentHashMap<>();
	
	public void register(Class<?> name, ExcelSheet sheet) {
		cache.put(name, sheet);
	}

}
