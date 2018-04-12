package com.stanslab.excel;

import java.util.List;

/**
 * 
 * @author Stalin
 *
 */
public class Sheet {
	
	private Class<?> clazz;
	
	private List<?> data;

	public Sheet(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Sheet(Class<?> clazz, List<?> data) {
		this.clazz = clazz;
		this.data = data;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
