package com.greatlearning.studentDebateMgmt.service;

import java.util.List;

import com.greatlearning.studentDebateMgmt.entity.Student;


public interface DebateService {

	public List<Student> getAllStudents();
	public void registerStudent(Student newStudent);
	public void deleteStudent(int stuId);
	public void updateStudent(int id,Student theStudent);
	public Student findById(int theId);
	
}
