package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(String theId);
		
	public void save(Employee theEmployee);
	
	public void deleteById(String theId);
	
	public List<Employee> findByCustom(String first_name, String last_name, String email);
	


	
}
