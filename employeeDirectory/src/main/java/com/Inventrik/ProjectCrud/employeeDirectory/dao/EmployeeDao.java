package com.Inventrik.ProjectCrud.employeeDirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventrik.ProjectCrud.employeeDirectory.entity.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
