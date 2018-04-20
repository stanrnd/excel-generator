package com.stanrnd.excel;

import com.stanrnd.excel.annotation.Column;
import com.stanrnd.excel.annotation.Header;
import com.stanrnd.excel.annotation.Sheet;
import com.stanrnd.excel.annotation.Title;

@Sheet(value = "Employee Sheet", title = @Title("Employee Details"))
public class Employee extends User {
	
	@Column(header = @Header("Salary"))
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
