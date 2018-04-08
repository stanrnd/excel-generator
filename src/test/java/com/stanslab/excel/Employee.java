package com.stanslab.excel;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelRow;

@ExcelRow(height = 30)
public class Employee extends User {
	
	@ExcelColumn("Salary")
	private float salary;

	public Employee(String id, String name, int age, String address, float salary) {
		super(id, name, age, address);
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
