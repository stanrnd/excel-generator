package com.stanslab.excel;

public class Employee extends User {
	
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
