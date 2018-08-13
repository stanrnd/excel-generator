package com.stanrnd.excel.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import com.stanrnd.excel.annotation.Column;
import com.stanrnd.excel.annotation.Ignore;
import com.stanrnd.excel.annotation.Sheet;
import com.stanrnd.excel.exception.ExcelParserException;
import com.stanrnd.excel.meta.ExcelColumn;
import com.stanrnd.excel.meta.ExcelSheet;
import com.stanrnd.excel.parser.bean.FieldValueParser;
import com.stanrnd.excel.parser.bean.MethodValueParser;

/**
 * 
 * @author Stalin
 *
 */
public class AnnotationExcelSheetParser {

	public static ExcelSheet parse(Class<?> clazz) throws ExcelParserException {
		Sheet sheet = clazz.getAnnotation(Sheet.class);
		if (sheet == null) {
			throw new ExcelParserException("@Sheet annotation not found at class " + clazz);
		}

		ExcelSheet excelSheet = new ExcelSheet(sheet);
		excelSheet.setColumns(new ArrayList<>(parseColumns(clazz)));

		return excelSheet;

	}

	private static Set<ExcelColumn> parseColumns(Class<?> clazz) throws ExcelParserException {
		try {
			if (clazz != Object.class) {
				Set<ExcelColumn> excelColumns = parseColumns(clazz.getSuperclass());

				Ignore ignore = clazz.getAnnotation(Ignore.class);
				if (ignore != null) {
					return excelColumns;
				}

				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					Column column = field.getAnnotation(Column.class);
					if (column != null) {
						excelColumns.add(new ExcelColumn(column, new FieldValueParser(field)));
					}
				}

				Method[] methods = clazz.getDeclaredMethods();
				for (Method method : methods) {
					Column column = method.getAnnotation(Column.class);
					if (column != null) {
						excelColumns.add(new ExcelColumn(column, new MethodValueParser(method)));
					}
				}

				return excelColumns;
			}
			return new LinkedHashSet<>();
		} catch (Exception e) {
			throw new ExcelParserException(e);
		}
	}

}
