package com.stanslab.excel.xml.parser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.stanslab.excel.meta.Color;
import com.stanslab.excel.meta.ExcelColumn;
import com.stanslab.excel.meta.ExcelData;
import com.stanslab.excel.meta.ExcelHeader;
import com.stanslab.excel.meta.ExcelSheet;
import com.stanslab.excel.meta.ExcelStyle;
import com.stanslab.excel.meta.ExcelTitle;
import com.stanslab.excel.meta.FontName;
import com.stanslab.excel.meta.FontSize;

public class XmlExcelMetaParser {

	public static List<ExcelSheet> parse() {
		List<ExcelSheet> excelSheets = new ArrayList<>();
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse("D:/project/pojo-excel/src/src/test/resources/pojo-excel.xml");
			doc.getDocumentElement().normalize();
			NodeList sheets = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < sheets.getLength(); i++) {
				Node sheet = sheets.item(i);
				if(sheet instanceof Element) {
					excelSheets.add(parseSheet((Element) sheet));
				}
			}
			return excelSheets;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static ExcelSheet parseSheet(Element excel) {
		ExcelSheet excelSheet = new ExcelSheet(excel.getAttribute("name"));
		NodeList sheetChilds = excel.getChildNodes();
		for (int j = 0; j < sheetChilds.getLength(); j++) {
			Node sheetChild = sheetChilds.item(j);
			if ("TITLE".equalsIgnoreCase(sheetChild.getNodeName())) {
				excelSheet.setTitle(parseTitle((Element) sheetChild));
			} else if ("COLUMNS".equalsIgnoreCase(sheetChild.getNodeName())) {
				List<ExcelColumn> excelColumns = new ArrayList<>();
				NodeList columns = sheetChild.getChildNodes();
				for (int l = 0; l < columns.getLength(); l++) {
					Node column = columns.item(l);
					if(column instanceof Element) {
						excelColumns.add(parseExcelColumn((Element) column));
					}
				}
				excelSheet.setColumns(excelColumns);
			}
		}
		return excelSheet;
	}
	
	private static ExcelTitle parseTitle(Element title) {
		ExcelTitle excelTitle = new ExcelTitle();
		
		parseExcelStyle(title, excelTitle);
		
		if(title.hasAttribute("text")) {
			excelTitle.setText(title.getAttribute("text"));
		}
		
		return excelTitle;
	}
	
	private static ExcelColumn parseExcelColumn(Element column) {
		ExcelColumn excelColumn = new ExcelColumn();
		if(column.hasAttribute("width")) {
			excelColumn.setWidth(Integer.parseInt(column.getAttribute("width")));
		}
		if(column.hasAttribute("order")) {
			excelColumn.setOrder(Integer.parseInt(column.getAttribute("order")));
		}
		NodeList columnChilds = column.getChildNodes();
		for (int l = 0; l < columnChilds.getLength(); l++) {
			Node columnChild = columnChilds.item(l);
			if(columnChild instanceof Element) {
				if ("HEADER".equalsIgnoreCase(columnChild.getNodeName())) {
					excelColumn.setHeader(parseExcelHeader((Element) columnChild));
				} else if ("DATA".equalsIgnoreCase(columnChild.getNodeName())) {
					excelColumn.setData(parseExcelData((Element) columnChild));
				}
			}
		}
		
		return excelColumn;
	}
	
	private static ExcelData parseExcelData(Element data) {
		ExcelData excelData = new ExcelData();
		
		parseExcelStyle(data, excelData);
		
		return excelData;
	}
	
	private static ExcelHeader parseExcelHeader(Element header) {
		ExcelHeader excelHeader = new ExcelHeader();
		
		parseExcelStyle(header, excelHeader);
		
		if(header.hasAttribute("text")) {
			excelHeader.setText(header.getAttribute("text"));
		}
		
		return excelHeader;
	}
	
	private static void parseExcelStyle(Element title, ExcelStyle excelStyle) {
		if(title.hasAttribute("height")) {
			excelStyle.setHeight(Integer.parseInt(title.getAttribute("height")));
		}
		
		if(title.hasAttribute("foreground")) {
			excelStyle.setForeground(Color.valueOf(title.getAttribute("foreground")));
		}
		
		if(title.hasAttribute("background")) {
			excelStyle.setBackground(Color.valueOf(title.getAttribute("background")));
		}
		
		if(title.hasAttribute("font-name")) {
			excelStyle.setFontName(FontName.valueOf(title.getAttribute("font-name")));
		}
		
		if(title.hasAttribute("font-size")) {
			excelStyle.setFontSize(FontSize.find(Integer.parseInt(title.getAttribute("font-size"))));
		}
		
		if(title.hasAttribute("italic")) {
			excelStyle.setItalic(Boolean.parseBoolean(title.getAttribute("italic")));
		}
		
		if(title.hasAttribute("bold")) {
			excelStyle.setBold(Boolean.parseBoolean(title.getAttribute("bold")));
		}
	}

	public static void main(String[] args) {
		parse();
	}

}
