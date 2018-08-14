package com.stanrnd.excel.xml;

import java.util.ArrayList;
import java.util.List;

import com.stanrnd.excel.ExcelEnvironment;
import com.stanrnd.excel.ExcelGenerator;
import com.stanrnd.excel.Sheet;
import com.stanrnd.excel.Type;
import com.stanrnd.excel.exception.ExcelException;

public class XmlTest {

	public static void main(String[] args) throws ExcelException {
		ExcelEnvironment.init();
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(11, "Stalin", "Bangalore", "Engineering", 25000f));
		employees.add(new Employee(12, "Raam", "Chennai", "IT", 20000f));
		employees.add(new Employee(13, "Alan", "Delhi", "Admin", 15000f));
		employees.add(new Employee(14, "Renu", "Bangalore", "QA", 50000f));
		employees.add(new Employee(15, "John", "Chennai", "Engineering", 60000f));
		
		List<Project> projects = new ArrayList<>();
		projects.add(new Project("Hotel Management", "Java", "Ibis, Sunray"));
		projects.add(new Project("Billing System", "C", "Amazon"));
		projects.add(new Project("Traffic Contoller", "C++", "Government"));
		
		ExcelGenerator.generate("d:/temp/software-ltd.xls", Type.XLS, new Sheet(Employee.class, employees), new Sheet(Project.class, projects));
		
		System.out.println("Done !!");
	}

}
