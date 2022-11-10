package com.greatlearning.studentDebateMgmt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentDebateMgmt.entity.Student;
import com.greatlearning.studentDebateMgmt.repository.StudentRepository;
import com.greatlearning.studentDebateMgmt.service.DebateService;

@Service
public class DebateServiceImpl implements DebateService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void registerStudent(Student newStudent) {
		studentRepository.save(newStudent);
	}

	@Override
	public void deleteStudent(int stuId) {
		studentRepository.deleteById(stuId);
		}
	


	@Override
	public void updateStudent(int id,Student theStudent) {
	 Optional<Student>updateStu=studentRepository.findById(id);
	 if(!updateStu.isEmpty())
	 {
		 updateStu.get().setFirstname(theStudent.getFirstname());
		 updateStu.get().setLastname(theStudent.getLastname());
		 updateStu.get().setCountry(theStudent.getCountry());
		 updateStu.get().setCourse(theStudent.getCourse());
		 
		 studentRepository.save(updateStu.get());
	 }
	}

	@Override
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
	}

}
