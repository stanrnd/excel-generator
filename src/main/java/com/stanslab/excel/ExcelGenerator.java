package com.stanslab.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class ExcelGenerator {
	
	final public static byte[] generate(ExcelType excelType, Sheet ... sheets) {
		
		return null;
	}
	
	final public static byte[] generate(ExcelSheet sheet, ExcelType excelType) {
		generate(ExcelType.XLS, new Sheet(String.class, new ArrayList<String>()), new Sheet(Integer.class, new ArrayList<Integer>()));
		byte[] bytes = excelType.getExcelBuilder().build(Arrays.asList(sheet));
		
		return bytes;
	}
	
	final public static byte[] generate(List<ExcelSheet> sheets, ExcelType excelType) {
		byte[] bytes = excelType.getExcelBuilder().build(sheets);
		
		return bytes;
	}
	
	final public static void generate(ExcelSheet sheet, ExcelType excelType, File file) {
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] bytes = excelType.getExcelBuilder().build(Arrays.asList(sheet));
			outputStream.write(bytes);
			outputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	final public static void generate(ExcelSheet sheet, ExcelType excelType, String fileName) {
		generate(sheet, excelType, new File(fileName));
	}
	
	final public static void generate(List<ExcelSheet> sheets, ExcelType excelType, File file) {
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] bytes = excelType.getExcelBuilder().build(sheets);
			outputStream.write(bytes);
			outputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	final public static void generate(List<ExcelSheet> sheets, ExcelType excelType, String fileName) {
		generate(sheets, excelType, new File(fileName));
	}

}
