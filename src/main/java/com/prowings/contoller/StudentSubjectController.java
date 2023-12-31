package com.prowings.contoller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prowings.entity.Student;
import com.prowings.entity.Subjects;
import com.prowings.service.StudentSubjectService;
import com.prowings.util.StudentNameComparator;

@RestController
public class StudentSubjectController {
	
	@Autowired
	StudentSubjectService studentSubjectService;
	
	@PostMapping("/students")
	public String saveStudent(HttpEntity<String> httpEntity) throws JsonMappingException, JsonProcessingException
	{
		String requestBody = httpEntity.getBody();
		System.out.println("Incoming Request is :"+ requestBody);
		
		System.out.println(httpEntity.getHeaders());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		Student std = objectMapper.readValue(requestBody,Student.class);
		
		System.out.println("Request received to create student : "+ std);
		
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
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student std) {
		System.out.println("request received to update student  : " + std);
		
		return studentSubjectService.updateStudent(std);
		
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable("id") int id) {
		System.out.println("request received to delete student with id : "+id);
		
		if(studentSubjectService.deleteStudent(id))
			return "Student deleted successfully!!";
		else
			return "error while deleteing specified student!!!";
	}
	
	
	

	
}
