package com.stanslab.excel;

import com.stanslab.excel.annotation.ExcelColumn;
import com.stanslab.excel.annotation.ExcelRow;
import com.stanslab.excel.annotation.Ignore;

public class User {
	
	private String id;

	@ExcelColumn(value = "Name", order = 6)
	private String name;
	
	private int age;
	
	@ExcelColumn(value = "Address", width = 5000, order = 5)
	private String address;

	public User(String id, String name, int age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ExcelColumn("Age")
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
