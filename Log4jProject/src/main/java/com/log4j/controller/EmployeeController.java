package com.log4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.log4j.exception.EmployeeExcep;
import com.log4j.model.Employee;
import com.log4j.service.EmployeeServ;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServ employeeServ;
	
	
	@PostMapping("/RegEmp")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) throws EmployeeExcep{
		
		Employee emp = employeeServ.registerEmployee(employee);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping("/EmpById/{id}")
	public ResponseEntity<Employee> serachById(@PathVariable("id") int id)throws EmployeeExcep{
		
		Employee employee = employeeServ.employeeByID(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	@GetMapping("/AllEmp")
	public ResponseEntity<List<Employee>> viewAllEmployee() throws EmployeeExcep{
		
		List<Employee> employees = employeeServ.viewAllEmployee();
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.ACCEPTED);
	}

}

