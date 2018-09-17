package com.stanrnd.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.stanrnd.excel.exception.ExcelException;
import com.stanrnd.excel.exception.ExcelInitializationException;
import com.stanrnd.excel.meta.ExcelSheet;
import com.stanrnd.excel.parser.AnnotationExcelSheetParser;
import com.stanrnd.excel.parser.XmlExcelSheetParser;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelEnvironment {
	
	private static ConcurrentMap<Class<?>, ExcelSheet> sheets;
	
	public static void init() throws ExcelInitializationException {
		
		init(new Config());
	}
	
	public static void init(Config config) throws ExcelInitializationException {
		try (InputStream inputStream = getStream(config.getXmlConfigPath())) {
			
			validateXML(inputStream);
		} catch (ExcelException e) {
			throw new ExcelInitializationException(e);
		} catch (Exception e) {
			throw new ExcelInitializationException(e);
		}
		
		try (InputStream inputStream = getStream(config.getXmlConfigPath())) {
			
			sheets = new ConcurrentHashMap<>(XmlExcelSheetParser.parse(inputStream));
		} catch (ExcelException e) {
			throw new ExcelInitializationException(e);
		} catch (Exception e) {
			throw new ExcelInitializationException(e);
		}
	}
	
	private static InputStream getStream(String xmlPath) throws ExcelException {
		try {
			if(xmlPath == null) {
				xmlPath = "classpath:excel-config.xml";
			}
			
			if(xmlPath.startsWith("classpath:")) {
				return XmlExcelSheetParser.class.getResourceAsStream("/" + xmlPath.substring("classpath:".length()));
			} else if(xmlPath.startsWith("file:")) {
				return new FileInputStream(xmlPath.substring("file:".length()));
			}
			
			throw new ExcelException("Invalid Xml config path " + xmlPath);
		} catch (Exception e) {
			throw new ExcelException(e);
		}
	}
	
	private static void validateXML(InputStream inputStream) throws ExcelException {
		try {
			URL schemaFile = new URL("https://github.com/stanrnd/excel-generator/raw/master/excel-config.xsd");
			Source xmlFile = new StreamSource(inputStream);
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
		} catch (SAXException e) {
			throw new ExcelException("Xml config validation error", e);
		} catch (IOException e) {
			throw new ExcelException("Xml config not found error", e);
		}
	}
	
	public static boolean isInited() {

		return sheets != null;
	}
	
	public static ExcelSheet getSheet(Class<?> clazz) throws ExcelException {
		if(sheets == null) {
			throw new ExcelInitializationException("Excel environment not initialized.");
		}
		if(sheets.containsKey(clazz)) {
			return sheets.get(clazz);
		}
		
		ExcelSheet excelSheet = AnnotationExcelSheetParser.parse(clazz);
		sheets.put(clazz, excelSheet);
		
		return excelSheet;
	}

}
