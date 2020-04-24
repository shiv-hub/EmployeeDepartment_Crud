package com.shiv.bootmvc.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Employee {
	
	@Id
	@Column(name="id")
	int id;
	@Column(name="firstName")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="age")
	int age;

	@Temporal(TemporalType.DATE)
	@Column(name="hireDate")
	Date hireDate;
	
	@Column(name="department")
	String department;
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	
	


	
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=Shape.STRING)
//	@Column(name="hire_date")
//	String hire_date;

	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", hireDate=" + hireDate + ", department=" + department + "]";
	}
	
	
	
	
}
