package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Supplier;

public interface SupplierService {

	public List<Supplier> findAll();
	
	public Supplier findById(int theId);
	
	public void save(Supplier theSupplier);
	
	public void deleteById(int theId);
	
}
