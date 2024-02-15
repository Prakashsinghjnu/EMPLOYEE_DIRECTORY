package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(long employeeId);
		
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);

	public void deleteById (long id);
}
