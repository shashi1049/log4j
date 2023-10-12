package com.log4j.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger LOG = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServ employeeServ;
	
	
	@PostMapping("/RegEmp")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) throws EmployeeExcep{
		LOG.info("RegEmp API called");
		Employee emp = employeeServ.registerEmployee(employee);
		LOG.info("Employee registered successfully.");
		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping("/EmpById/{id}")
	public ResponseEntity<Employee> serachById(@PathVariable("id") int id)throws EmployeeExcep{
		LOG.info("Employee by Id API called");
		Employee employee = employeeServ.employeeByID(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	@GetMapping("/AllEmp")
	public ResponseEntity<List<Employee>> viewAllEmployee() throws EmployeeExcep{
		LOG.info("AllEmp API called");
		List<Employee> employees = employeeServ.viewAllEmployee();
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.ACCEPTED);
	}

}

