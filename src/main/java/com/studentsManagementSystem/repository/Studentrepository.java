package com.studentsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentsManagementSystem.entity.student;
@Repository
public interface Studentrepository extends JpaRepository<student , Integer>{

}
