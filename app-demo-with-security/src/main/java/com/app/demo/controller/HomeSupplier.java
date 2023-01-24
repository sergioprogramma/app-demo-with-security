package com.app.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.demo.entity.Employee;
import com.app.demo.entity.Owner;
import com.app.demo.service.EmployeeService;
import com.app.demo.service.OwnerService;


@Controller
@RequestMapping("/home-supplier")
public class HomeSupplier {
	
	private OwnerService ownerService;
	private EmployeeService employeeService;
	
	public HomeSupplier(OwnerService theOwnerService, EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
		ownerService = theOwnerService;

	}
	
	@GetMapping("/")
	public String homeSupplier(Model theModel) {
		
		// get employees from db
		List<Owner> theOwners = ownerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("owners", theOwners);
		
		System.out.println(theOwners);
		
		List<String> ids = new LinkedList<String>();
		for (Owner o : theOwners) {
		    ids.add((String) o.getOwnerid());
		}
		
		// get employees from db
		List<Employee> theEmployeesFiltered = new LinkedList<Employee>();

		for (String i : ids) {
			theEmployeesFiltered.add(employeeService.findById(i));
		}
				
		// add to the spring model
		theModel.addAttribute("employees", theEmployeesFiltered);
		
		
		return "home-suppliers";
	}
}











