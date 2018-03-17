package com.stanslab.excel.meta.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelRow;
import com.stanslab.excel.annotation.Ignore;
import com.stanslab.excel.meta.ColumnMeta;
import com.stanslab.excel.meta.ExcelMeta;
import com.stanslab.excel.meta.RowMeta;
import com.stanslab.excel.pojo.parser.FieldValueParser;
import com.stanslab.excel.pojo.parser.MethodValueParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelMetaParser {
	
	public static ExcelMeta parseExcelMeta(Class<?> clazz) {
		ExcelMeta excelMeta = new ExcelMeta();
		
		ExcelRow excelRow = parseExcelRow(clazz);
		RowMeta rowMeta = new RowMeta();
		rowMeta.setHeight(excelRow.height());
		excelMeta.setRowMeta(rowMeta);
		
		List<ColumnMeta> columnMetas = new ArrayList<>(parseColumns(clazz));
		Collections.sort(columnMetas);
		excelMeta.setColumnMetas(columnMetas);
		
		return excelMeta;
	}
	
	private static ExcelRow parseExcelRow(Class<?> clazz) {
		ExcelRow excelRow = clazz.getAnnotation(ExcelRow.class);
		if(excelRow != null) {
			return excelRow;
		}
		if(clazz != Object.class) {
			return parseExcelRow(clazz.getSuperclass());
		}
		return ExcelRow.DEFAULT;
	}
	
	private static Set<ColumnMeta> parseColumns(Class<?> clazz) {
		if(clazz != Object.class) {
			Set<ColumnMeta> columnMetas = parseColumns(clazz.getSuperclass());
			
			Ignore ignore = clazz.getAnnotation(Ignore.class);
			if(ignore != null) {
				return columnMetas;
			}
			
			Method[] methods = clazz.getDeclaredMethods();
			for(Method method:methods) {
				ExcelColumn excelColumn = method.getAnnotation(ExcelColumn.class);
				if(excelColumn != null) {
					ColumnMeta columnMeta = new ColumnMeta(excelColumn.value());
					if(!columnMetas.contains(columnMeta)) {
						columnMeta.setName(method.getName().substring(3));
						columnMeta.setName(excelColumn.value());
						columnMeta.setWidth(excelColumn.width());
						columnMeta.setOrder(excelColumn.order());
						columnMeta.setValueParser(new MethodValueParser(method));
						columnMetas.add(columnMeta);
					}
				}
			}
			
			Field[] fields = clazz.getDeclaredFields();
			for(Field field:fields) {
				ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
				field.setAccessible(true);
				ColumnMeta columnMeta = new ColumnMeta();
				if(excelColumn != null) {
					columnMeta.setName(excelColumn.value());
					if(columnMetas.contains(columnMeta)) {
						columnMetas.remove(columnMeta);
					}
					columnMeta.setWidth(excelColumn.width());
					columnMeta.setOrder(excelColumn.order());
					columnMeta.setValueParser(new FieldValueParser(field));
					columnMetas.add(columnMeta);
				}
			}
			
			return columnMetas;
		}
		return new LinkedHashSet<>();
	}

}
