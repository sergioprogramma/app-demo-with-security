package com.app.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.OwnerRepository;
import com.app.demo.entity.Owner;

@Service
public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository ownerRepository;
	
	@Autowired
	public OwnerServiceImpl(OwnerRepository theOwnerRepository) {
		ownerRepository = theOwnerRepository;
	}
	
	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner findById(int theId) {
		Optional<Owner> result = ownerRepository.findById(theId);
		
		Owner theOwner = null;
		
		if (result.isPresent()) {
			theOwner = result.get();
		}
		else {
			// we didn't find the supplier
			throw new RuntimeException("Did not find owner id - " + theId);
		}
		
		return theOwner;
	}

	@Override
	public void save(Owner theOwner) {
		ownerRepository.save(theOwner);
	}

	@Override
	public void deleteById(int theId) {
		ownerRepository.deleteById(theId);
	}


}






