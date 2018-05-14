package com.stanrnd.excel.annotation;

@Sheet(value = "Project Sheet", title = @Title("Project Details"))
public class Project {
	
	@Column
	private String name;
	
	@Column
	private String technology;
	
	@Column
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
