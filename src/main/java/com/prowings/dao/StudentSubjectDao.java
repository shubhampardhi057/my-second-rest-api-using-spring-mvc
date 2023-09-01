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
	
	public List<Subjects> getStudentSubjectByID(int id);

	public List<Student> getStudentsPagination(Integer firstResult, Integer maxResult);

	public Student updateStudent(Student std);

	public boolean deleteStudent(int id);
	

	
}
