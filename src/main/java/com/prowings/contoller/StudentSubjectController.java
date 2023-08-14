package com.prowings.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.entity.Subjects;
import com.prowings.service.StudentSubjectService;

@RestController
public class StudentSubjectController {
	
	@Autowired
	StudentSubjectService studentSubjectService;
	
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student std)
	{
		if(studentSubjectService.saveStudent(std))
			return "Student Saved Successfully !!!";
		else
			return "Student Not Saved Successfully !!!";
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return studentSubjectService.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int  id)
	{
		return studentSubjectService.getStudent(id);
	}
	
	@GetMapping("/students/{id}/subjects/{id}")
	public Subjects getStudentSubject(@PathVariable int  id)
	{
		return studentSubjectService.getStudentSubject(id);
	}
	
	@GetMapping("/subjects")
	public List<Subjects> getSubjects()
	{
		return studentSubjectService.getSubject();
	}

	
}
