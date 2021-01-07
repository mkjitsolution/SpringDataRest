package com.mkj.test.SpringRESTHibernate.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mkj.test.SpringRESTHibernate.dto.Instructor;

public interface InstructorService {

	public List<Instructor> getAllInstructors();
	
	public List<Instructor> getAllInstructorsbyExp();
	
	@Query("From Instructor order by salary ASC")
	public List<Instructor> getAllInstructorsbySalary();
	
	public List<Instructor> getAllInstructorsbyLocation(String location);
	
	
}
