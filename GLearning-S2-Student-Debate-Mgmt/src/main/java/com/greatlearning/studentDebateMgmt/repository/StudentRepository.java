package com.greatlearning.studentDebateMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentDebateMgmt.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
