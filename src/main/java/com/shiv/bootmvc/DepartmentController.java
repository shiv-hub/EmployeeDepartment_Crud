package com.shiv.bootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiv.bootmvc.dao.DepartmentDao;
import com.shiv.bootmvc.model.Department;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentDao ddao;
	//test for github
	@GetMapping(value="/department")
	public List<Department> getAllDepartment(){
		return ddao.findAll(); 
	}
	
}
