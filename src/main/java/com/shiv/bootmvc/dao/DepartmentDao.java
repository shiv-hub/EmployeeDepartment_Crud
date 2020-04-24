package com.shiv.bootmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiv.bootmvc.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
