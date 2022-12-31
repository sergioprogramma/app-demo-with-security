package com.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {

	// define fields
	
	@Id
	@Column(name="owner_id")
	private int ownerid;
	
	@Column(name="store_name")
	private String storeName;
	
	@Column(name="city")
	private String city;
	
	// define constructors
	
	public Owner() {
		
	}
	
	public Owner(int id, String storeName, String city) {
		this.ownerid = id;
		this.storeName = storeName;
		this.city = city;

	}


	public Owner(String storeName, String city) {
		this.storeName = storeName;
		this.city = city;
	}

	// define getter/setter
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	

	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", storeName=" + storeName + ", city=" + city + "]";
	}
	
}











