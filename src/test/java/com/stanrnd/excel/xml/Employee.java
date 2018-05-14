package com.stanrnd.excel.xml;

public class Employee extends User {

	private String dept;
	
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
