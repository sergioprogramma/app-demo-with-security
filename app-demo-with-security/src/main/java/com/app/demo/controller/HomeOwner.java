package com.app.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.demo.entity.Employee;
import com.app.demo.entity.Supplier;
import com.app.demo.service.EmployeeService;
import com.app.demo.service.SupplierService;


@Controller
@RequestMapping("/home-owner")
public class HomeOwner {
	
	private SupplierService supplierService;
	private EmployeeService employeeService;
	
	public HomeOwner(SupplierService theSupplierService, EmployeeService theEmployeeService) {
		supplierService = theSupplierService;
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/")
	public String showHomeForOwner(Model theModel) {
	// get employees from db
	List<Supplier> theSuppliers = supplierService.findAll();
	
	// add to the spring model
	theModel.addAttribute("suppliers", theSuppliers);
	
	System.out.println(theSuppliers);
	
	List<Integer> ids = new LinkedList<Integer>();
	for (Supplier s : theSuppliers) {
	    ids.add((int) s.getSupplierid());
	}
	
	// get employees from db
	List<Employee> theEmployeesFiltered = new LinkedList<Employee>();

	for (Integer i : ids) {
		theEmployeesFiltered.add(employeeService.findById(i));
	}
			
	// add to the spring model
	theModel.addAttribute("employees", theEmployeesFiltered);
	
	
	return "home-owners";
	}
}











