package com.studentsManagementSystem.service;

import java.util.List;

import com.studentsManagementSystem.entity.student;

public interface StudentService {

	public List<student> getAllStudents();

	public student saveStudent(student student);
	
	public student getById(int id);
	
	public void deleteById(int id);
}
