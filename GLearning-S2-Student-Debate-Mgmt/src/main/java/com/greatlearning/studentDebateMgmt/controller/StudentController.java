package com.greatlearning.studentDebateMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.studentDebateMgmt.entity.Student;
import com.greatlearning.studentDebateMgmt.service.DebateService;

@RestController
public class StudentController {
	


	private DebateService debateService;
	
	@Autowired
	public StudentController(DebateService theStuService) {
		debateService=theStuService;
	}
	
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Student Debate application";
	}
	
//	@RequestMapping("/")
//	public String testStr(Model m) {
//		List<Student> students=debateService.getAllStudents();
//		m.addAttribute("Students", students);
//		return "allstudents-view";
//	}
	
	@RequestMapping("/printAllStudents")
	public String showStudentsForm(Model m) {
		List<Student> students=debateService.getAllStudents();
		m.addAttribute("Students", students);
		return "allstudents-view";
	}
	
	@RequestMapping("/registerStudent")
	public String addNewStudentForm(Model m) {
		Student newStudent=new Student();
		m.addAttribute("Student",newStudent);
		return "student-form-view";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudentForm(@RequestParam("studentId")int id,Model m) {
		Student student=debateService.findById(id);
		m.addAttribute("Student", student);
		return "student-form-view";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudentFromDebateForm(@RequestParam("studentId")int id) {
		debateService.deleteStudent(id);
		return "redirect:/printAllStudents";
	}
	
	@PostMapping("/save")
	public String saveStudentRegistration(@RequestParam("studentId")int id,
			@RequestParam("firstname")String _fname,
			@RequestParam("lastname")String _lname,
			@RequestParam("course")String _course,
			@RequestParam("country")String _country) {
		
		Student newStudent;
		if(id!=0) {
			newStudent=debateService.findById(id);
			newStudent.setFirstname(_fname);
			newStudent.setLastname(_lname);
			newStudent.setCourse(_course);
			newStudent.setCountry(_country);
		}
		else
		{
			newStudent=new Student();
			newStudent.setFirstname(_fname);
			newStudent.setLastname(_lname);
			newStudent.setCourse(_course);
			newStudent.setCountry(_country);
		}
			
		debateService.registerStudent(newStudent);
		return "redirect:/printAllStudents";
	}
}
