package com.stanslab.excel;

import com.stanslab.excel.annotation.Column;
import com.stanslab.excel.annotation.Data;
import com.stanslab.excel.annotation.Header;
import com.stanslab.excel.annotation.Sheet;
import com.stanslab.excel.annotation.Title;

@Sheet("Student Sheet")
public class Student extends User {
	
	@Column
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
