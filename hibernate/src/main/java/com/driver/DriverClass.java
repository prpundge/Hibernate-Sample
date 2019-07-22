package com.driver;

import java.util.List;

import com.dao.StudentDao;
import com.entities.Student;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDao();
		Student s = new Student(10, "pravin", "prpundge");
		dao.saveStudent(s);

		List<Student> studlist = dao.getstudent();
		studlist.forEach(l -> System.out.println(l));

	}

}
