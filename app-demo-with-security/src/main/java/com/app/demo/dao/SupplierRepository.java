package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.demo.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Supplier> findAll();
	
	@Query(value = "SELEC * FROM supplier WHERE num_employees < :max_value", nativeQuery = true)
	List<Supplier> findByNumEmployees(Integer max_value);
	
}
