package com.greatlearning.studentDebateMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="course")
	private String course;
	
	@Column(name="country")
	private String country;
	
}
