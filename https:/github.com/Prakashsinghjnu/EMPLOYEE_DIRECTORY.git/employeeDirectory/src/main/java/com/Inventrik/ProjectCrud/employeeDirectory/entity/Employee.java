package com.Inventrik.ProjectCrud.employeeDirectory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Employee {

	//define fields
	
	@Id
	
	private int id;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastNmae=" + lastNmae + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNmae() {
		return lastNmae;
	}
	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastNmae, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastNmae = lastNmae;
		this.email = email;
	}
	private String firstName;
	private String lastNmae;
	private String email;
	//define constructors
	//define getter/setter
	//define toString
	
	
}
