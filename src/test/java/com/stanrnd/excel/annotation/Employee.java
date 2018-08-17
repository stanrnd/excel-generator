package com.stanrnd.excel.annotation;

import com.stanrnd.excel.meta.Color;

@Sheet(value = "Employee Sheet", title = @Title(value="Employee Details", fontColor=Color.GREEN))
public class Employee extends User {

	@Column(header = @Header("Department"), order=3)
	private String dept;
	
	@Column(header = @Header(underline=5), data = @Data(fontColor=Color.RED, bold=true))
	private Float salary;

	public Employee(Integer id, String name, String address, String department, Float salary) {
		super(id, name, address);
		this.dept = department;
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
}
