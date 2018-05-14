package com.stanrnd.excel.xml;

public class Project {
	
	private String name;
	
	private String technology;
	
	private String clients;

	public Project(String name, String technology, String clients) {
		this.name = name;
		this.technology = technology;
		this.clients = clients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getClients() {
		return clients;
	}

	public void setClients(String clients) {
		this.clients = clients;
	}
	
}
