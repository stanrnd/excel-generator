package com.stanrnd.excel;

import java.io.File;
import java.io.FileOutputStream;

import com.stanrnd.excel.exception.ExcelException;

/**
 * 
 * @author Stalin
 *
 */
final public class ExcelGenerator {
	
	private ExcelGenerator() {
		
	}
	
	final public static byte[] generate(Type type, Sheet ... sheets) throws ExcelException {
		
		return type.getExcelBuilder().build(sheets);
	}
	
	final public static void generate(File file, Type type, Sheet ... sheets) throws ExcelException {
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			byte[] bytes = type.getExcelBuilder().build(sheets);
			outputStream.write(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	final public static void generate(String fileName, Type type, Sheet ... sheets) throws ExcelException {
		generate(new File(fileName), type, sheets);
	}

}
