package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	// that's it ... no need to write any code LOL!
	
	// add custom queries
	// add a method to sort by last name
	
	public List<Employee> findAllByOrderByLastNameAsc();
	
	@Query(value = "SELECT * FROM employee WHERE id = :id", nativeQuery = true)
	public Employee findByStringId(String id);
	
	@Query(value = "SELECT * FROM employee WHERE first_name = :first_name OR last_name = :last_name OR email = :email", nativeQuery = true)
	List<Employee> findByCustom(String first_name, String last_name, String email);
	
	
}
