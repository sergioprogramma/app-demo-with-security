package com.app.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.demo.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Owner> findAll();
	
	@Query(value = "SELECT * FROM Owner WHERE city = :city", nativeQuery = true)
	List<Owner> findByCity(String city);
	
}
