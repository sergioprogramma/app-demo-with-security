package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Owner> findAll();
	
}
