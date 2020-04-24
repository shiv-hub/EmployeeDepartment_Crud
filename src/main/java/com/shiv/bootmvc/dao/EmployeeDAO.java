package com.shiv.bootmvc.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shiv.bootmvc.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	
	
	// for particular date
	  List<Employee> findByHireDate(Date hire_date);
	  Optional<Employee> findByFirstName(String firstName);
	  
	  // for employees before given Date
//	  @Query("FROM employee WHERE hire_date<?1")
	  List<Employee> findByHireDateLessThan(Date hire_date);
	  
	  // for employees before given Date
	  List<Employee> findByHireDateGreaterThan(Date hire_date);
	  
	// for employees between given Date
	  List<Employee> findByHireDateBetween(Date hire_date1,Date hire_date2);
}
