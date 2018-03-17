package com.stanslab.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AnnotationTest {

	@Test
	public void test() {
		
		ExcelSheet excelSheet1 = new ExcelSheet("Student Sheet 1", "Student Details");
		List<Student> students1 = new ArrayList<>();
		students1.add(new Student("11", "Stalin", 30, "Bangalore", "MCA"));
		students1.add(new Student("12", "Nikson", 22, "Chennai", "BE"));
		students1.add(new Student("13", "Banu", 25, "Chennai", "BE"));
		excelSheet1.setRows(students1, Student.class);
		
		ExcelSheet excelSheet2 = new ExcelSheet("Student Sheet 2", "Student Details");
		List<Student> students2 = new ArrayList<>();
		students2.add(new Student("11", "Stalin", 30, "Bangalore", "MCA"));
		students2.add(new Student("12", "Nikson", 22, "Chennai", "BE"));
		students2.add(new Student("13", "Banu", 25, "Chennai", "BE"));
		excelSheet2.setRows(students2, Student.class);
		
		ExcelGenerator.generate(Arrays.asList(excelSheet1, excelSheet2), ExcelType.XLS, "D:/temp/student.xls");
		
		System.out.println("Done !!");
	}

}
