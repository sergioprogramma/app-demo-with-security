package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Supplier> findAll();
	
}
