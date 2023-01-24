package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Supplier;

public interface SupplierService {

	public List<Supplier> findAll();
	
	public Supplier findById(String theId);
	
	public void save(Supplier theSupplier);
	
	public void deleteById(String theId);
	
	public List<Supplier> findByNumEmployees(Integer max_value);
	
}
