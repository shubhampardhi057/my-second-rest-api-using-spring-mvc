package com.prowings.service;

import java.util.List;

import com.prowings.entity.Student;
import com.prowings.entity.Subjects;

public interface StudentSubjectService {
	
	public boolean saveStudent(Student std);
	
	public List<Student> getStudents();
	
	public Student getStudent(int id);
	
	public Subjects getStudentSubject(int id);

	public List<Subjects> getSubject();
	

}