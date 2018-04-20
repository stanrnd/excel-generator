package com.stanrnd.excel;

import com.stanrnd.excel.annotation.Column;
import com.stanrnd.excel.annotation.Header;
import com.stanrnd.excel.annotation.Ignore;

public class User {
	
	private String id;

	@Column
	private String name;
	
	private int age;
	
	@Column
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

	@Column(header = @Header("Age"))
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
