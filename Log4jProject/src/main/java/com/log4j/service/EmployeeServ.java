package com.log4j.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.log4j.exception.EmployeeExcep;
import com.log4j.model.Employee;

@Service
public interface EmployeeServ {
	
	public Employee registerEmployee(Employee emp) throws EmployeeExcep;
	
	public Employee employeeByID(int id)throws EmployeeExcep;

    public List<Employee> viewAllEmployee()throws EmployeeExcep;

    

}