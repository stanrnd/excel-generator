package com.stanslab.excel.builder;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.stanslab.excel.ExcelSheet;
import com.stanslab.excel.builder.ExcelBuilder;
import com.stanslab.excel.meta.ColumnMeta;
import com.stanslab.excel.meta.ExcelMeta;
import com.stanslab.excel.meta.ExcelMetaFactory;
import com.stanslab.excel.meta.RowMeta;

/**
 * 
 * @author Stalin
 *
 */
public class XLSExcelBuilder implements ExcelBuilder {

	@Override
	public byte[] build(List<ExcelSheet> excelSheets) {
		try {
			Workbook workbook = new HSSFWorkbook();
			for (ExcelSheet excelSheet : excelSheets) {
				Sheet sheet = workbook.createSheet(excelSheet.getName());
				ExcelMeta excelMeta = ExcelMetaFactory.get(excelSheet.getRowType());
				build(workbook, sheet, excelSheet, excelMeta);
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);

			return outputStream.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void build(Workbook workbook, Sheet sheet, ExcelSheet excelSheet, ExcelMeta excelMeta) {
		RowMeta rowMeta = excelMeta.getRowMeta();
		
		int rowNumber = -1;
		int columnNumber = -1;
		
		Row titleRow = sheet.createRow(++rowNumber);
		titleRow.setHeightInPoints(rowMeta.getHeight());
		Cell titleCell = titleRow.createCell(++columnNumber);
		titleCell.setCellValue(excelSheet.getTitle());
		titleCell.setCellStyle(getTitleCellStyle(workbook));
		if(excelMeta.getColumnMetas().size() > 1) {
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, excelMeta.getColumnMetas().size()-1);
			sheet.addMergedRegion(cellRangeAddress);
		}
		
		columnNumber = -1;
		Row headerRow = sheet.createRow(++rowNumber);
		headerRow.setHeightInPoints(rowMeta.getHeight());
		for (ColumnMeta columnMeta : excelMeta.getColumnMetas()) {
			Cell cell = headerRow.createCell(++columnNumber);
			cell.setCellValue(columnMeta.getName());
			cell.setCellStyle(getHeaderCellStyle(workbook));
			if(columnMeta.getWidth() == -1) {
				sheet.autoSizeColumn(columnNumber, true);
			} else {
				sheet.setColumnWidth(columnNumber, columnMeta.getWidth());
			}
		}
		
		List<?> rows = excelSheet.getRows();
		for(Object excelRow:rows) {
			Row row = sheet.createRow(++rowNumber);
			row.setHeightInPoints(rowMeta.getHeight());
			columnNumber = -1;
			for (ColumnMeta columnMeta : excelMeta.getColumnMetas()) {
				Cell cell = row.createCell(++columnNumber);
				Object value = columnMeta.getValue(excelRow);
				if(value instanceof String) {
					cell.setCellValue((String) value);
				} else {
					cell.setCellValue(value.toString());
				}
			}
		}
		
		setBorder(sheet, rows.size(), excelMeta.getColumnMetas().size());
	}
	
	private CellStyle getTitleCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		Font font= workbook.createFont();
		font.setFontHeightInPoints((short)11);
		font.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
	    font.setBold(true);
		style.setFont(font);
		return style;
	}
	
	private CellStyle getHeaderCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		Font font= workbook.createFont();
	    font.setBold(true);
	    font.setItalic(true);
		style.setFont(font);
		style.setFillPattern(FillPatternType.LEAST_DOTS);
		style.setFillBackgroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		return style;
	}
	
	private void setBorder(Sheet sheet, int rows, int cols) {
		CellRangeAddress bottonBorderRange = new CellRangeAddress(1, 1, 0, cols-1);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, bottonBorderRange, sheet);
		
		CellRangeAddress borderRange = new CellRangeAddress(1, rows+1, 0, cols-1);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, borderRange, sheet);
	}

}
