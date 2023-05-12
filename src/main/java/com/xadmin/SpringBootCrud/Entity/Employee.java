package com.xadmin.SpringBootCrud.Entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Builder
@Table(name="employees")
public class Employee {
	
	@Id
	private Long id;
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@Column(name="department", nullable=false, length=50)
	private String department;
	
	
	
	public Employee() {
		
	}


	public Employee(Long id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				'}';
	}
}
