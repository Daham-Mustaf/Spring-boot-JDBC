package com.daham.DAO;

import java.util.List;

import com.daham.api.Student;

public interface StudentDAO {

	List<Student> loadSudents();
	void addStudent(Student student);
	Student getStudentById(int id);
	void update(Student student);
	void deletStudent(Student student);
	void addList(List<Student> studentList);
	

}
