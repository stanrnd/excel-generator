package com.stanrnd.excel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

@Ignore
public class AnnotationTest extends TestCase {
	
	@Test
	public void test() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("11", "Stalin", 30, "Bangalore, \"India\"", 20000f));
		employees.add(new Employee("12", "Mani", 22, "Chennai", 25000f));
		employees.add(new Employee("13", "Banu", 25, "Chennai", 15000f));
		
		ExcelGenerator.generate("D:/temp/excel/employee.xls", Type.XLS, new Sheet(Employee.class, employees));
		
		ExcelGenerator.generate("D:/temp/excel/employee.zip", Type.CSV, new Sheet(Employee.class, employees));
		
		System.out.println("Done !!");
	}

}
