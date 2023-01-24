package com.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name="supplier")
public class Supplier {

	// define fields
	
	@Id
	@Column(name="supplier_id")
	private String supplierid;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="deleted")
    private boolean deleted = Boolean.FALSE;
	
	// define constructors
	
	public Supplier() {
		
	}
	
	public Supplier(String supplierid, String companyName, String city) {
		this.supplierid = supplierid;
		this.companyName = companyName;
		this.city = city;

	}


	public Supplier(String companyName, String city) {
		this.companyName = companyName;
		this.city = city;
	
	}

	// define getter/setter

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
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
