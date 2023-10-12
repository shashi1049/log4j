package com.log4j.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4j.exception.EmployeeExcep;
import com.log4j.general.App;
import com.log4j.model.Employee;
import com.log4j.repository.EmployeeRepo;
import com.log4j.service.EmployeeServ;

@Service
public class EmployeeServiceImpl implements EmployeeServ{
	
	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeExcep {
		// TODO Auto-generated method stub
		Employee employee = empRepo.save(emp);
		LOG.info("Employee saved in DB successfully.");
		
		
		return employee;
	}

	@Override
	public Employee employeeByID(int id) throws EmployeeExcep {
		// TODO Auto-generated method stub
		
		Optional<Employee> empOptional = empRepo.findById(id);
		
		if(empOptional.isEmpty()) {
			LOG.error("Employee with id: "+ id +" does not exist");
			throw new EmployeeExcep("Employee with id -> "+id +" does not exist");
			
		}
		else {
			LOG.info("Employee with id: " +id + " found");
			return empOptional.get();
		}
		
	}

	@Override
	public List<Employee> viewAllEmployee() throws EmployeeExcep {
		// TODO Auto-generated method stub
		
		List<Employee> employees = empRepo.findAll();
		
		if(employees.isEmpty()) {
			LOG.error("No employee available in list.");
			throw new EmployeeExcep("Number of employee is zero");
		}
		else {
			LOG.info("List of Employee found");
			return employees;
		}
		
	}

}
