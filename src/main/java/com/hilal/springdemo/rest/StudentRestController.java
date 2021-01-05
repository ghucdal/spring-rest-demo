package com.hilal.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hilal.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>(); 
		theStudents.add(new Student("poornima","patel"));
		theStudents.add(new Student("mario","rossi"));
		theStudents.add(new Student("mary","smith"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//by list index
		
		//check the studentId against list size
		
		if(studentId >= theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	} 
	
}
