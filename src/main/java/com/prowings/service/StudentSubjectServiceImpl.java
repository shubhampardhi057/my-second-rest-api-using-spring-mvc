package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentSubjectDao;
import com.prowings.entity.Student;
import com.prowings.entity.Subjects;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {


	@Autowired
	StudentSubjectDao studentSubjetDao;
	
	@Override
	public boolean saveStudent(Student std) {
		
		return studentSubjetDao.saveStudent(std);
	}

	@Override
	public List<Student> getStudents() {
		
		return studentSubjetDao.getStudents();
	}

	@Override
	public Student getStudent(int id) {
		return studentSubjetDao.getStudent(id);
	}

	@Override
	public Subjects getStudentSubject(int id) {
		
		return studentSubjetDao.getStudentSubject(id);
	}

	@Override
	public List<Subjects> getSubject() {
		
		return studentSubjetDao.getSubjects();
	}

	@Override
	public List<Subjects> getStudentSubjectByID(int id) {
		
		return studentSubjetDao.getStudentSubjectByID(id);
	}

	@Override
	public List<Student> getStudentsPagination(Integer firstResult, Integer maxResult) {
		
		return studentSubjetDao.getStudentsPagination(firstResult,maxResult);
	}
}
