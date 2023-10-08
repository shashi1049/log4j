package com.log4j.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4j.exception.EmployeeExcep;
import com.log4j.model.Employee;
import com.log4j.repository.EmployeeRepo;
import com.log4j.service.EmployeeServ;

@Service
public class EmployeeServiceImpl implements EmployeeServ{
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeExcep {
		// TODO Auto-generated method stub
		Employee employee = empRepo.save(emp);
		
		return employee;
	}

	@Override
	public Employee employeeByID(int id) throws EmployeeExcep {
		// TODO Auto-generated method stub
		
		Optional<Employee> empOptional = empRepo.findById(id);
		
		if(empOptional.isEmpty()) {
			throw new EmployeeExcep("Employee with id -> "+id +" does not exist");
		}
		else {
			return empOptional.get();
		}
		
	}

	@Override
	public List<Employee> viewAllEmployee() throws EmployeeExcep {
		// TODO Auto-generated method stub
		
		List<Employee> employees = empRepo.findAll();
		
		if(employees.isEmpty()) {
			throw new EmployeeExcep("Number of employee is zero");
		}
		else {
			return employees;
		}
		
	}

}
