package com.studentsManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentsManagementSystem.entity.student;
import com.studentsManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students",service.getAllStudents());
		
		return "students";
	}
	
	
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		student stu = new student();
		model.addAttribute("student", stu);
		
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") student student) {
		
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		
		model.addAttribute("student", service.getById(id));
		
		return "edit-student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") student student) {
		
		student existingStudent=service.getById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		service.saveStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		
		service.deleteById(id);
		
		return "redirect:/students";
	}
}
