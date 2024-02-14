package com.Inventrik.ProjectCrud.employeeDirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventrik.ProjectCrud.employeeDirectory.dao.EmployeeDao;
import com.Inventrik.ProjectCrud.employeeDirectory.entity.Employee;

@Service 
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeedao;
	public EmployeeServiceimpl(EmployeeDao theEmployeeDao) {
		employeedao=theEmployeeDao;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeedao.findAll();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> byId = employeedao.findById(employeeId);
		Employee result=null;
		if(byId.isPresent()) {
			result=byId.get();
		}
		return result;
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedao.save(employee);
		return employee;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeedao.findById(id);
		Employee entity=null;
		if(result.isPresent()) {
			entity=result.get();
		}
		employeedao.delete(entity);
		
		
	}

}
