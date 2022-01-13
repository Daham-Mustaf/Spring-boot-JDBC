package com.daham.service;

import java.util.List;

import com.daham.api.Student;

public interface StudentService {
	List<Student> loadStudents();

	void saveStudent(Student student);
	Student findStudentById(int id);
	void update(Student student);
	void deletStudent(Student student);
	//Saving a list of objects at once
	public void add(List<Student> studentList) ;

}
