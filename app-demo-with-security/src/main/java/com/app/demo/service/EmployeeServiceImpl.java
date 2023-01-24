package com.app.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.EmployeeRepository;
import com.app.demo.dao.OwnerRepository;
import com.app.demo.dao.SupplierRepository;
import com.app.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private SupplierRepository supplierRepository;
	private OwnerRepository ownerRepository;

	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository, SupplierRepository theSupplierRepository, OwnerRepository theOwnerRepository) {
		employeeRepository = theEmployeeRepository;
		supplierRepository = theSupplierRepository;
		ownerRepository = theOwnerRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(String theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(String theId) {
		try { 
			supplierRepository.deleteById(theId);
			ownerRepository.deleteById(theId);
			employeeRepository.deleteById(theId);
			
		} catch (Exception e) {
			System.out.println("they are not both suppliers and owners");
		}
			
		try {
		
			supplierRepository.deleteById(theId);
			employeeRepository.deleteById(theId);
				
		} catch (Exception i) {
			System.out.println("They are not suppliers");
			}
		
		try { 
			
			ownerRepository.deleteById(theId);
			employeeRepository.deleteById(theId);
			
		} catch (Exception a) {
			employeeRepository.deleteById(theId);
			}		

	}

	@Override
	public List<Employee> findByCustom(String first_name, String last_name, String email) {
		return employeeRepository.findByCustom(first_name, last_name, email);
	}


}
