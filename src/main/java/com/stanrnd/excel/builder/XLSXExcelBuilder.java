package com.stanrnd.excel.builder;

import java.io.ByteArrayOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stanrnd.excel.ExcelEnvironment;
import com.stanrnd.excel.builder.ExcelBuilder;
import com.stanrnd.excel.exception.ExcelBuilderException;
import com.stanrnd.excel.meta.ExcelSheet;

/**
 * 
 * @author Stalin
 *
 */
public class XLSXExcelBuilder extends AbstractExcelBuilder implements ExcelBuilder {

	@Override
	public byte[] build(com.stanrnd.excel.Sheet[] sheetDatas) throws ExcelBuilderException {
		try {
			Workbook workbook = new XSSFWorkbook();
			for (com.stanrnd.excel.Sheet sheetData : sheetDatas) {
				ExcelSheet excelSheet = ExcelEnvironment.getSheet(sheetData.getClazz());
				build(workbook, excelSheet, sheetData.getData());
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);

			return outputStream.toByteArray();
		} catch (Exception e) {
			throw new ExcelBuilderException(e);
		}
	}

}
