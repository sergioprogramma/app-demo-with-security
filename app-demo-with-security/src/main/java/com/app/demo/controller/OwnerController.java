package com.app.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.entity.Owner;
import com.app.demo.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private OwnerService ownerService;
	
	public OwnerController(OwnerService theOwnerService) {
		ownerService = theOwnerService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listOwner(Model theModel) {
		
		// get employees from db
		List<Owner> theOwners = ownerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("owners", theOwners);
		
		return "owners/list-owners";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Owner theOwner= new Owner();
		
		theModel.addAttribute("owner", theOwner);
		
		return "owners/owner-form";
	}


	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ownerId") int theId,
									Model theModel) {
		// get the employee from the service
		try { 
		Owner theOwner = ownerService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("owner", theOwner);
		} catch (Exception e) {
			return "redirect:/owners/showFormForAdd";	
		}
		
		// send over to our form
		return "owners/owner-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("owner") Owner theOwner) {
		
		// save the employee
		ownerService.save(theOwner);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("ownerId") int theId) {
		
		// delete the employee
		ownerService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/owners/list";
		
	}
	
}









