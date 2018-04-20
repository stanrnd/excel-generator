package com.stanrnd.excel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

@Ignore
public class XmlTest extends TestCase {

	@Test
	public void test() {
		
		Sheet sheet1 = new Sheet(Student.class);
		List<Student> students1 = new ArrayList<>();
		students1.add(new Student("11", "Stalin", 30, "Bangalore", "MCA"));
		students1.add(new Student("12", "Nikson", 22, "Chennai", "BE"));
		students1.add(new Student("13", "Banu", 25, "Chennai", "BE"));
		sheet1.setData(students1);
		
		Sheet sheet2 = new Sheet(Student.class);
		List<Student> students2 = new ArrayList<>();
		students2.add(new Student("11", "Stalin", 30, "Bangalore", "MCA"));
		students2.add(new Student("12", "Nikson", 22, "Chennai", "BE"));
		students2.add(new Student("13", "Banu", 25, "Chennai", "BE"));
		sheet2.setData(students2);
		
		ExcelGenerator.generate("D:/temp/student.xls", Type.XLS, sheet1);
		
		System.out.println("Done !!");
	}

}
