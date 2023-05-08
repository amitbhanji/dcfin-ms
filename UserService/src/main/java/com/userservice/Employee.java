package com.userservice;

import java.security.Timestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private int id;
	private String name; 
	private String role;
	private Timestamp insertTime;
	public Employee()
	{
		
	}
	public Employee(int id, String name, String role, Timestamp datetime) {
	
		this.id = id;
		this.name = name;
		this.role = role;
		this.insertTime = datetime;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public Timestamp getDatetime() {
		return insertTime;
	}
	@Override
	public String toString() {
		
		//Timestamp time = insertTime;
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", datetime=" + insertTime + "]";
	}
	
	
}
