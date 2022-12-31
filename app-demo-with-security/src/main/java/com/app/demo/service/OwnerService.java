package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Owner;

public interface OwnerService {

	public List<Owner> findAll();
	
	public Owner findById(int theId);
	
	public void save(Owner theOwner);
	
	public void deleteById(int theId);
	
}