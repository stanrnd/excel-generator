package com.stanrnd.excel.builder;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.stanrnd.excel.Sheet;
import com.stanrnd.excel.builder.ExcelBuilder;
import com.stanrnd.excel.meta.ExcelColumn;
import com.stanrnd.excel.meta.ExcelSheet;
import com.stanrnd.excel.meta.ExcelSheetFactory;

/**
 * 
 * @author Stalin
 *
 */
public class CSVExcelBuilder implements ExcelBuilder {

	@Override
	public byte[] build(Sheet[] sheets) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream out = new ZipOutputStream(baos);
			for (Sheet sheet:sheets) {
				ExcelSheet excelSheet = ExcelSheetFactory.get(sheet.getClazz());
				StringBuilder sheetBuilder = buildSheet(excelSheet, sheet.getData());
				ZipEntry ze = new ZipEntry(excelSheet.getName() + ".csv");
				out.putNextEntry(ze);
				out.write(sheetBuilder.toString().getBytes());
				out.closeEntry();
			}
			out.close();
			return baos.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public StringBuilder buildSheet(ExcelSheet excelSheet, List<?> rows) {
		StringBuilder builder = new StringBuilder();
		builder.append(buildRowHeader(excelSheet.getColumns()));
		builder.append('\n');
		for(Object row:rows) {
			builder.append(buildRowData(row, excelSheet.getColumns()));
			builder.append('\n');
		}
		return builder;
	}
	
	public StringBuilder buildRowHeader(List<ExcelColumn> columns) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<columns.size();i++) {
			ExcelColumn column = columns.get(i);
			if (i > 0) {
				builder.append(',');
			}
			String columnValue = column.getHeader().getText();
			builder.append('"');
			if (columnValue.indexOf('"') > -1) {
				for (int j = 0; j < columnValue.length(); j++) {
					char c = columnValue.charAt(j);
					if (c == '"') {
						builder.append('"');
					}
					builder.append(c);
				}
			} else {
				builder.append(columnValue);
			}
			builder.append('"');
		}
		return builder;
	}
	
	public StringBuilder buildRowData(Object row, List<ExcelColumn> columns) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<columns.size();i++) {
			ExcelColumn column = columns.get(i);
			Object value = column.getValueParser().parse(row);
			if (i > 0) {
				builder.append(',');
			}
			if (value == null) {
				continue;
			}
			String columnValue = value instanceof String ? (String) value : value.toString();
			builder.append('"');
			if (columnValue.indexOf('"') > -1) {
				for (int j = 0; j < columnValue.length(); j++) {
					char c = columnValue.charAt(j);
					if (c == '"') {
						builder.append('"');
					}
					builder.append(c);
				}
			} else {
				builder.append(columnValue);
			}
			builder.append('"');
		}
		return builder;
	}

}
