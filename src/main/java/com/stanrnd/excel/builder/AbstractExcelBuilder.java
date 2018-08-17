package com.stanrnd.excel.builder;

import java.util.EnumMap;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.stanrnd.excel.meta.Color;
import com.stanrnd.excel.meta.ExcelColumn;
import com.stanrnd.excel.meta.ExcelSheet;
import com.stanrnd.excel.meta.ExcelStyle;
import com.stanrnd.excel.meta.ExcelTitle;
import com.stanrnd.excel.meta.FillPattern;

abstract public class AbstractExcelBuilder {
	
	final protected static EnumMap<Color, Short> colorCodes = new EnumMap<>(Color.class);
	
	final protected static EnumMap<FillPattern, FillPatternType> fillPatterns = new EnumMap<>(FillPattern.class);
	
	static {
		colorCodes.put(Color.BLACK, (short) 8);
		colorCodes.put(Color.WHITE, (short) 9);
		colorCodes.put(Color.RED, (short) 10);
		colorCodes.put(Color.BRIGHT_GREEN, (short) 11);
		colorCodes.put(Color.BLUE, (short) 12);
		colorCodes.put(Color.YELLOW, (short) 13);
		colorCodes.put(Color.PINK, (short) 14);
		colorCodes.put(Color.TURQUOISE, (short) 15);
		colorCodes.put(Color.DARK_RED, (short) 16);
		colorCodes.put(Color.GREEN, (short) 17);
		colorCodes.put(Color.DARK_BLUE, (short) 18);
		colorCodes.put(Color.DARK_YELLOW, (short) 19);
		colorCodes.put(Color.VIOLET, (short) 20);
		colorCodes.put(Color.TEAL, (short) 21);
		colorCodes.put(Color.GREY_25_PERCENT, (short) 22);
		colorCodes.put(Color.GREY_50_PERCENT, (short) 23);
		colorCodes.put(Color.CORNFLOWER_BLUE, (short) 24);
		colorCodes.put(Color.MAROON, (short) 25);
		colorCodes.put(Color.LEMON_CHIFFON, (short) 26);
		colorCodes.put(Color.LIGHT_TURQUOISE1, (short) 27);
		colorCodes.put(Color.ORCHID, (short) 28);
		colorCodes.put(Color.CORAL, (short) 29);
		colorCodes.put(Color.ROYAL_BLUE, (short) 30);
		colorCodes.put(Color.LIGHT_CORNFLOWER_BLUE, (short) 31);
		colorCodes.put(Color.SKY_BLUE, (short) 40);
		colorCodes.put(Color.LIGHT_TURQUOISE, (short) 41);
		colorCodes.put(Color.LIGHT_GREEN, (short) 42);
		colorCodes.put(Color.LIGHT_YELLOW, (short) 43);
		colorCodes.put(Color.PALE_BLUE, (short) 44);
		colorCodes.put(Color.ROSE, (short) 45);
		colorCodes.put(Color.LAVENDER, (short) 46);
		colorCodes.put(Color.TAN, (short) 47);
		colorCodes.put(Color.LIGHT_BLUE, (short) 48);
		colorCodes.put(Color.AQUA, (short) 49);
		colorCodes.put(Color.LIME, (short) 50);
		colorCodes.put(Color.GOLD, (short) 51);
		colorCodes.put(Color.LIGHT_ORANGE, (short) 52);
		colorCodes.put(Color.ORANGE, (short) 53);
		colorCodes.put(Color.BLUE_GREY, (short) 54);
		colorCodes.put(Color.GREY_40_PERCENT, (short) 55);
		colorCodes.put(Color.DARK_TEAL, (short) 56);
		colorCodes.put(Color.SEA_GREEN, (short) 57);
		colorCodes.put(Color.DARK_GREEN, (short) 58);
		colorCodes.put(Color.OLIVE_GREEN, (short) 59);
		colorCodes.put(Color.BROWN, (short) 60);
		colorCodes.put(Color.PLUM, (short) 61);
		colorCodes.put(Color.INDIGO, (short) 62);
		colorCodes.put(Color.GREY_80_PERCENT, (short) 63);
		colorCodes.put(Color.AUTOMATIC, (short) 64);
	}
	
	static {
		fillPatterns.put(FillPattern.NO_FILL, FillPatternType.NO_FILL);
		fillPatterns.put(FillPattern.SOLID_FOREGROUND, FillPatternType.SOLID_FOREGROUND);
		fillPatterns.put(FillPattern.FINE_DOTS, FillPatternType.FINE_DOTS);
		fillPatterns.put(FillPattern.ALT_BARS, FillPatternType.ALT_BARS);
		fillPatterns.put(FillPattern.SPARSE_DOTS, FillPatternType.SPARSE_DOTS);
		fillPatterns.put(FillPattern.THICK_HORZ_BANDS, FillPatternType.THICK_HORZ_BANDS);
		fillPatterns.put(FillPattern.THICK_VERT_BANDS, FillPatternType.THICK_VERT_BANDS);
		fillPatterns.put(FillPattern.THICK_BACKWARD_DIAG, FillPatternType.THICK_BACKWARD_DIAG);
		fillPatterns.put(FillPattern.THICK_FORWARD_DIAG, FillPatternType.THICK_FORWARD_DIAG);
		fillPatterns.put(FillPattern.BIG_SPOTS, FillPatternType.BIG_SPOTS);
		fillPatterns.put(FillPattern.BRICKS, FillPatternType.BRICKS);
		fillPatterns.put(FillPattern.THIN_HORZ_BANDS, FillPatternType.THIN_HORZ_BANDS);
		fillPatterns.put(FillPattern.THIN_VERT_BANDS, FillPatternType.THIN_VERT_BANDS);
		fillPatterns.put(FillPattern.THIN_BACKWARD_DIAG, FillPatternType.THIN_BACKWARD_DIAG);
		fillPatterns.put(FillPattern.THIN_FORWARD_DIAG, FillPatternType.THIN_FORWARD_DIAG);
		fillPatterns.put(FillPattern.SQUARES, FillPatternType.SQUARES);
		fillPatterns.put(FillPattern.DIAMONDS, FillPatternType.DIAMONDS);
		fillPatterns.put(FillPattern.LESS_DOTS, FillPatternType.LESS_DOTS);
		fillPatterns.put(FillPattern.LEAST_DOTS, FillPatternType.LEAST_DOTS);
	}
	
	protected void build(Workbook workbook, ExcelSheet excelSheet, List<?> rowDatas) {
		Sheet sheet = workbook.createSheet(excelSheet.getName());
		
		int rowNumber = -1;
		int columnNumber = -1;
		
		List<ExcelColumn> excelColumns = excelSheet.getColumns();
		
		ExcelTitle excelTitle = excelSheet.getTitle();
		if(excelTitle != null && !"".equals(excelTitle.getText())) {
			Row titleRow = sheet.createRow(++rowNumber);
			if(excelTitle.getHeight() == 0) {
				titleRow.setHeight((short) 350);
			} else {
				titleRow.setHeight((short) excelTitle.getHeight());
			}
			
			Cell titleCell = titleRow.createCell(++columnNumber);
			titleCell.setCellValue(excelTitle.getText());
			titleCell.setCellStyle(getCellStyle(workbook, excelTitle));
			if(excelColumns.size() > 1) {
				CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, excelColumns.size()-1);
				sheet.addMergedRegion(cellRangeAddress);
			}
		}
		
		columnNumber = -1;
		Row headerRow = sheet.createRow(++rowNumber);
		int maxHeaderHeight = 300;
		for (ExcelColumn excelColumn : excelColumns) {
			Cell cell = headerRow.createCell(++columnNumber);
			cell.setCellValue(excelColumn.getHeader().getText());
			cell.setCellStyle(getCellStyle(workbook, excelColumn.getHeader()));
			if(excelColumn.getWidth() == 0) {
				sheet.autoSizeColumn(columnNumber);
			} else {
				sheet.setColumnWidth(columnNumber, excelColumn.getWidth());
			}
			if(maxHeaderHeight < excelColumn.getHeader().getHeight()) {
				maxHeaderHeight = excelColumn.getHeader().getHeight();
			}
		}
		headerRow.setHeight((short) maxHeaderHeight);
		
		for(Object rowData:rowDatas) {
			int maxDataHeight = 300;
			Row row = sheet.createRow(++rowNumber);
			columnNumber = -1;
			for (ExcelColumn excelColumn : excelColumns) {
				Cell cell = row.createCell(++columnNumber);
				Object value = excelColumn.getValueParser().parse(rowData);
				if(value instanceof String) {
					cell.setCellValue((String) value);
				} else {
					cell.setCellValue(value.toString());
				}
				cell.setCellStyle(getCellStyle(workbook, excelColumn.getData()));
				if(excelColumn.getWidth() == 0) {
					sheet.autoSizeColumn(columnNumber);
				} else {
					sheet.setColumnWidth(columnNumber, excelColumn.getWidth());
				}
				if(maxDataHeight < excelColumn.getHeader().getHeight()) {
					maxDataHeight = excelColumn.getHeader().getHeight();
				}
			}
			row.setHeight((short) maxDataHeight);
		}
		
		setBorder(excelSheet, sheet, rowDatas.size(), excelColumns.size());
	}
	
	private CellStyle getCellStyle(Workbook workbook, ExcelStyle excelStyle) {
		CellStyle style = workbook.createCellStyle();
		Font font= workbook.createFont();
		font.setFontName(excelStyle.getFontName());
		font.setFontHeightInPoints(excelStyle.getFontSize().getSize());
		font.setColor(colorCodes.get(excelStyle.getFontColor()));
	    font.setBold(excelStyle.isBold());
	    font.setItalic(excelStyle.isItalic());
	    if(excelStyle.getUnderline() > 0) {
	    	font.setUnderline(excelStyle.getUnderline());
	    }
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillPattern(fillPatterns.get(excelStyle.getFillPattern()));
		style.setFillForegroundColor(colorCodes.get(excelStyle.getFillForeground()));
		style.setFillBackgroundColor(colorCodes.get(excelStyle.getFillBackground()));
		return style;
	}
	
	private void setBorder(ExcelSheet excelSheet, Sheet sheet, int rows, int cols) {
		int titleRow = excelSheet.getTitle() != null && !"".equals(excelSheet.getTitle().getText()) ? 1 : 0;
		
		CellRangeAddress bottonBorderRange = new CellRangeAddress(titleRow, titleRow, 0, cols-1);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, bottonBorderRange, sheet);
		
		CellRangeAddress borderRange = new CellRangeAddress(titleRow, rows + titleRow, 0, cols-1);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, borderRange, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, borderRange, sheet);
	}

}
