package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employers {
	
	@Id
	private long id;
	private String fname;
	private String lname;
	private String depertment;
	private boolean active;
	
	public Employers(long id, String fname, String lname, String depertment, boolean active) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.depertment = depertment;
		this.active = active;
	}
	
	

	public Employers() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDepertment() {
		return depertment;
	}

	public void setDepertment(String depertment) {
		this.depertment = depertment;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
