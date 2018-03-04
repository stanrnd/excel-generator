package com.stanslab.excel;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelHeader;
import com.stanslab.excel.annotation.ExcelRow;

@ExcelRow(height = 50)
@ExcelHeader(value = "Student Details", height = 50)
public class Student {
	
	@ExcelColumn("Name")
	private String name;
	
	@ExcelColumn("Age")
	private int age;
	
	@ExcelColumn(value = "Address", width = 1000)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
