package com.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {

	// define fields
	
	@Id
	@Column(name="supplier_id")
	private int supplierid;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="city")
	private String city;
	
	// define constructors
	
	public Supplier() {
		
	}
	
	public Supplier(int supplierid, String companyName, String city) {
		this.supplierid = supplierid;
		this.companyName = companyName;
		this.city = city;

	}


	public Supplier(String companyName, String city) {
		this.companyName = companyName;
		this.city = city;
	
	}

	// define getter/setter

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", companyName=" + companyName + ", city=" + city + "]";
	}

	
}
