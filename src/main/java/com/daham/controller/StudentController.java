package com.daham.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daham.api.Student;
import com.daham.service.StudentService;

@Controller
public class StudentController {
//	@Autowired
//	private StudentDAO StudentDAO;
	@Autowired
	private StudentService studentService;

	@GetMapping("/showStuden")
	public String showStudentList(Model model) {

		List<Student> loadSudents = studentService.loadStudents();
		model.addAttribute("sudents", loadSudents);
		return "student-list";
	}

	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		if(student.getId()==0) {
		studentService.saveStudent(student);
		}
		else {
			studentService.update(student);
		}
		return "redirect:/showStuden";
		
	}

	@ResponseBody
	@GetMapping("/thankyou")
	public String thankyou() {
		return "Thank you you have been added sussecefully..";
	}

	@PostMapping("/update-student")
	public String updateStudent(@RequestParam("userId") int id, @ModelAttribute("student") Student student) {
		//Student student = new Student();
		
		studentService.findStudentById(id);
		return "redirect:/thankyou";
	}
	
	@GetMapping("/delet")
	@ResponseBody
	public String delet(@ModelAttribute("student") Student student) {
		studentService.deletStudent(student);
		
		return "delet";
	}
	

}
