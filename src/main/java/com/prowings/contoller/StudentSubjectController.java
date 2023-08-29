package com.prowings.contoller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.entity.Subjects;
import com.prowings.service.StudentSubjectService;
import com.prowings.util.StudentNameComparator;

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
	public List<Student> getAllStudents()
	{
		return studentSubjectService.getStudents();
		
	}
	
	
//	@GetMapping("/students")   //Pagination
//	public List<Student> getAllStudnts(@RequestParam(required = false)Integer firstResult,@RequestParam(required = true) Integer maxResult)
//	{
//		if((firstResult != null) && (maxResult != null))
//			return studentSubjectService.getStudentsPagination(firstResult,maxResult);
//		else
//			return studentSubjectService.getStudents();
//	}
	
	
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int  id)
	{
		return studentSubjectService.getStudent(id);
	}
	
	@GetMapping("/students/{id}/subjects")
	public List<Subjects> getStudentSubjectByID(@PathVariable int  id)
	{
		return studentSubjectService.getStudentSubjectByID(id);
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
	
	@GetMapping("/students/sortbyname") // Sorting 
	public List<Student> getAllStudentsSortedByName() 
	{
		
		List<Student> stdList = studentSubjectService.getStudents();
		
//		Collections.sort(stdList,new StudentNameComparator());
		
		return stdList;
		
	}
	
	

	
}
