package com.studentsManagementSystem.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsManagementSystem.entity.student;
import com.studentsManagementSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	com.studentsManagementSystem.repository.Studentrepository Studentrepository;
	
	@Override
	public List<student> getAllStudents() {
		// TODO Auto-generated method stub
		return Studentrepository.findAll();
	}

	@Override
	public student saveStudent(student student) {
		return Studentrepository.save(student);
		
	}

	@Override
	public student getById(int id) {
		
		return Studentrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {

		Studentrepository.deleteById(id);
	}

	

}




