package com.app.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.SupplierRepository;
import com.app.demo.entity.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository supplierRepository;
	
	@Autowired
	public SupplierServiceImpl(SupplierRepository theSupplierRepository) {
		supplierRepository = theSupplierRepository;
	}
	
	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier findById(String theId) {
		Optional<Supplier> result = supplierRepository.findById(theId);
		
		Supplier theSupplier = null;
		
		if (result.isPresent()) {
			theSupplier = result.get();
		}
		else {
			// we didn't find the supplier
			throw new RuntimeException("Did not find supplier id - " + theId);
		}
		
		return theSupplier;
	}

	@Override
	public void save(Supplier theSupplier) {
		supplierRepository.save(theSupplier);
	}

	@Override
	public void deleteById(String theId) {
		supplierRepository.deleteById(theId);
	}

	@Override
	public List<Supplier> findByNumEmployees(Integer max_value) {
		return supplierRepository.findByNumEmployees(max_value);
	}


}






