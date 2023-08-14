package com.prowings.dao;

import java.util.List;

import com.prowings.entity.Student;
import com.prowings.entity.Subjects;

public interface StudentSubjectDao {
	
	public boolean saveStudent(Student std);
	
	public List<Student> getStudents();
	
	public Student getStudent(int id);
	
	public Subjects getStudentSubject(int id);

	public List<Subjects> getSubjects();
	

}