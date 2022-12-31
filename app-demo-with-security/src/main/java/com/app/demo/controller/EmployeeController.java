package com.app.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.entity.Employee;
import com.app.demo.service.EmployeeService;
import com.app.demo.service.OwnerService;
import com.app.demo.service.SupplierService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	private SupplierService supplierService;
	private OwnerService ownerService;
	
	public EmployeeController(EmployeeService theEmployeeService, SupplierService theSupplierService, OwnerService theOwnerService) {
		employeeService = theEmployeeService;
		supplierService = theSupplierService;
		ownerService = theOwnerService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}


	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "employees/employee-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		
		try { 
			
			supplierService.deleteById(theId);
			ownerService.deleteById(theId);
			employeeService.deleteById(theId);
			
		} catch (Exception e) {
			System.out.println("they are not both suppliers and owners");
		}
			
		try {
		
			supplierService.deleteById(theId);
			employeeService.deleteById(theId);
				
		} catch (Exception i) {
			System.out.println("They are not suppliers");
			}
		
		try { 
			
			ownerService.deleteById(theId);
			employeeService.deleteById(theId);
			
		} catch (Exception a) {
				employeeService.deleteById(theId);
			}
		
		// redirect to /employees/list
		return "redirect:/employees/list";
		
	}
}


















