package com.daham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daham.DAO.StudentDAO;
import com.daham.api.Student;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@Override
	public List<Student> loadStudents() {

		return studentDAO.loadSudents();
	}

	@Override
	public void saveStudent(Student student) {

		if (student.getCountry().equals("UK")) {
			System.out.println("the mail sent to " + student.getName());
		}

		studentDAO.addStudent(student);

	}

	@Override
	public Student findStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public void update(Student student) {
		studentDAO.update(student);
	}

	@Override
	public void deletStudent(Student student) {
		studentDAO.deletStudent(student);
		
	}

	@Override
	public void add(List<Student> studentList) {
	
		studentDAO.addList(studentList);
	}
	

}
