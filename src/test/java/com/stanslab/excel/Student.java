package com.stanslab.excel;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelRow;

@ExcelRow(height = 30)
public class Student extends User {
	
	@ExcelColumn("Department")
	private String department;

	public Student(String id, String name, int age, String address, String department) {
		super(id, name, age, address);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
