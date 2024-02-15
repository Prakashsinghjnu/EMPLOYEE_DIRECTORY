package com.luv2code.springboot.cruddemo.Rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImp;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeServiceImp employeeService;
	
	@GetMapping("/home")
	public String home() {
		
		return "This is home page";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll() {
		
		return this.employeeService.getEmployees();
	}
//	@GetMapping("/employee/{employeeId}")
//	public Employee getEmployee(@PathVariable String employeeId) {
//		return employeeService.getEmployee(Integer.parseInt(employeeId));
//	}
	@GetMapping("/employee/{employeeId}")
	public Employee employee(@PathVariable String employeeId) {
	    return this.employeeService.getEmployee(Long.parseLong(employeeId)); 
	}

	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody  Employee employee) {
		return this.employeeService.addEmployee(employee);
	}
	@PutMapping("/employee")
		public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.updateEmployee(employee);
	}
	@DeleteMapping("/employee/{employeeId}")
	public void deleteById(@PathVariable String employeeId) {
		this.employeeService.deleteById(Long.parseLong(employeeId));
	}
	

}
