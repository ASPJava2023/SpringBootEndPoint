package com.exampleDay4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exampleDay4.bean.Student;

@RestController
public class StudentController {
	/*
	 * This end point will use Get to display (return) String Message in response 
	 */
	@GetMapping("/displayMessage")
	public String displayMessage() {
		
		return "This is Hello From ankit";
	}
	
	/*
	 * This end point will use Get to display (return) create Student Object in JSON in response.
	 * The Student Object is created in backend and only display in JSON 
	 */
	
	@GetMapping("/getStudent")
	public Student getStudent() {
		Student student = new Student(101,"Ankit");
		return student;
	}
	/*
	 * This end point will use Get to display (return) list of Students Object in JSON in response.
	 * The Student List Object is created in backend and only display in JSON 
	 	 */
	
	@GetMapping("/getStudentList")
	public List <Student> getStudentList() {
		ArrayList <Student> List = new ArrayList<Student>();
		List.add(new Student(101,"Ram"));
		List.add(new Student(102,"Raj"));
		List.add(new Student(103,"Tom"));
		List.add(new Student(104,"Sham"));
		Student student1 = new Student(100,"Ankit");
		List.add(student1);
		return List;
		}
	
	/*
	 * This end point will use Get  and @PathVariable to set Mannualy enter id
	 * (return) Students Object in JSON in response with Mannualy enter id.
	 * @PathVariable is used to pass variable in URL
	  */
	
	@GetMapping("/getStudentBy/{id}")
	public Student getStudentBy(@PathVariable("id")int id) 
	{	
		Student student3 = new Student(id,"Mohan lal");
		
		return student3;
	}
	/*
	 * This end point will use Get  and @RequestParam  to accept variable comeing from Frontend Form
	 * (return) Students Object in JSON in response with provided single/mutiple variable.
	 * @@RequestParam is used to send input to end point
	  */
	
	@GetMapping("/getStudentByQuery/query")
	public Student getStudentByQuery(@RequestParam int id,@RequestParam String name) 
	{	
		Student student4 = new Student(id,name);
		
		return student4;
		
	}
	@GetMapping("/getStudentByCustomQuery/query2")
	public String getStudentByCustomQuery(@RequestParam int id,@RequestParam String name) 
	{	
		Student student5 = new Student(id,name);
		
		return "Hi This is  "+student5.getSname()+ " And is his batch number is  "+student5.getSid() ;
		
	}
	/*
	 * This end point will use/create Put  to create a object provide in Body in JSON by user to create Object
	 * (return) Students Object in back end based on JSON property.
	 *  @ResponseStatus(HttpStatus.CREATED) will tell about Sucessful object creating
	 
	  */
	
	@PostMapping("/Student/Create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student6) 
	{	
		
		System.out.println(student6.getSid());
		System.out.println(student6.getSname());
		return student6;
		
	}
	@PutMapping("/Student/{id}updateStudent")
	public Student updateStudent(@RequestBody Student student7,@PathVariable("id")int id ) {
		student7.setSid(id);
		System.out.println(student7.getSid());
		System.out.println(student7.getSname());
		return student7;

	}
	@DeleteMapping("/Student/{id}/deletStudent")
	public String deletStudent(@PathVariable("id")int id) {
		return "Record deleted";
	}
}
