package com.mkj.test.SpringRESTHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mkj.test.SpringRESTHibernate.dao.InstructorRepository;
import com.mkj.test.SpringRESTHibernate.dto.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorRepository repo;
	
	@Override
	public List<Instructor> getAllInstructors() {
		return repo.findAll();  // method implemented by JPA Internally
	}

	@Override
	public List<Instructor> getAllInstructorsbyExp() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("jobstartyear").ascending());
	}

	@Override
	public List<Instructor> getAllInstructorsbySalary() {
		return repo.findAll();
	}
	
	@Override
	public List<Instructor> getAllInstructorsbyLocation(String location) {
		return repo.getInstructorByLocation(location);
	}
	
	
}











