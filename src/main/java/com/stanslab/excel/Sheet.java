package com.stanslab.excel;

import java.util.List;

public class Sheet {
	
	private Class<?> clazz;
	
	private List<?> data;

	public Sheet(Class<?> clazz, List<?> data) {
		this.clazz = clazz;
		this.data = data;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public List<?> getData() {
		return data;
	}

}
