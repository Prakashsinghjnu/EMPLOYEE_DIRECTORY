package com.Inventrik.ProjectCrud.employeeDirectory.service;

import java.util.List;

import com.Inventrik.ProjectCrud.employeeDirectory.entity.Employee;



public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
		
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);

	public void deleteById (int id);
}
