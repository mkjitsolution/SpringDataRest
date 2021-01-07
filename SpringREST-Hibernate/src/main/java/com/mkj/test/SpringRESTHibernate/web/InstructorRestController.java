package com.mkj.test.SpringRESTHibernate.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.test.SpringRESTHibernate.dao.InstructorDAO;
import com.mkj.test.SpringRESTHibernate.dto.Instructor;
import com.mkj.test.SpringRESTHibernate.execption.InstructorNotFoundException;
import com.mkj.test.SpringRESTHibernate.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorRestController {

	@Autowired          // Appraoch based on Hibernate
	private InstructorDAO dao;  // constructor injection
	
	@Autowired			// Apprach based on Spring JPA Data
	private InstructorService insService;
	
	
	public InstructorRestController() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(" Rest Controller Constructor ");
	}
	
	
	@GetMapping("/jpa/trainers")
	public List<Instructor> getAllInstructorsThroughJPAData()
	{
		return insService.getAllInstructors();
	}
	
	@GetMapping("/jpa/trainers/exp")
	public List<Instructor> getAllInstructorsThroughJPAData2()
	{
		return insService.getAllInstructorsbyExp();
	}
	
	@GetMapping("/jpa/trainers/location/{location}")
	public List<Instructor> getAllInstructorsThroughJPAData3(@PathVariable String location)
	{
		return insService.getAllInstructorsbyLocation(location);
	}
	
	

	
	
	@GetMapping("/root")
	public String root()
	{
		System.out.println(" --- inside root()");
		return "x=10 , y = 20";
	}
	
	@GetMapping("/trainers")
	public List<String> getAllInstructors()
	{
		// fetch all instructors from database
		// call dao to access Liust<String>
		
		// convert into json/xml / any ther business supported format
	
		//return List of trainers
		
		//return Arrays.asList("ashish","aprajit","gaurav");
		
		return dao.getAllInstructorsName();
	}
	
	
	@GetMapping("/trainers/info")
	public List<Instructor> getAllInstructorsInfo()
	{
		// fetch all instructors from database
		// call dao to access Liust<String>
		
		// convert into json/xml / any ther business supported format
	
		//return List of trainers
		
		return dao.getAllInstructorsInfo();
		
	}
	
	@GetMapping("/trainer/{id}")
	public Instructor getAllInstructorsInfo(@PathVariable int id)throws InstructorNotFoundException
	{
		return dao.getInstructorById(id);
	}
	
	
	@PostMapping("/trainer")
	public String saveInstructor(@RequestBody Instructor instructor)
	{
		String msg = dao.insertInstructor(instructor);
		return msg;
	}
	
	
	
	
}
