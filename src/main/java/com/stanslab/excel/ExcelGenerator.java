package com.stanslab.excel;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 
 * @author Stalin
 *
 */
final public class ExcelGenerator {
	
	private ExcelGenerator() {
		
	}
	
	final public static byte[] generate(Type type, Sheet ... sheets) {
		
		return type.getExcelBuilder().build(sheets);
	}
	
	final public static void generate(File file, Type type, Sheet ... sheets) {
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			byte[] bytes = type.getExcelBuilder().build(sheets);
			outputStream.write(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	final public static void generate(String fileName, Type type, Sheet ... sheets) {
		generate(new File(fileName), type, sheets);
	}

}
