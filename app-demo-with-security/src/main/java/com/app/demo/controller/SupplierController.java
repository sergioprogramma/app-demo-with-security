package com.app.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.entity.Supplier;
import com.app.demo.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

	private SupplierService supplierService;
	
	public SupplierController(SupplierService theSupplierService) {
		supplierService = theSupplierService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listSuppliers(Model theModel) {
		
		// get employees from db
		List<Supplier> theSuppliers = supplierService.findAll();
		
		// add to the spring model
		theModel.addAttribute("suppliers", theSuppliers);
		
		return "suppliers/list-suppliers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Supplier theSupplier = new Supplier();
		
		theModel.addAttribute("supplier", theSupplier);
		
		return "suppliers/supplier-form";
	}


	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("supplierId") int theId,
									Model theModel) {
		try {
		// get the employee from the service
		Supplier theSupplier = supplierService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("supplier", theSupplier);
		} catch (Exception e) {
			return "redirect:/suppliers/showFormForAdd";			
		}
		 
		// send over to our form
		return "suppliers/supplier-form";			
	}
	

	
}


















