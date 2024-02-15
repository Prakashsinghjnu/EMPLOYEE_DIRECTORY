package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeServiceImp() {
		
	}
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeDao.findById(employeeId);
		Employee ans=null;
		if(result.isPresent()) {
			ans=result.get();
		}
		return ans;
	}

	@Transactional
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		return employee;
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		Employee entity=employeeDao.getById(id);
		employeeDao.delete(entity);
		
	}
	
	
	

}
