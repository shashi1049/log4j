package com.log4j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.log4j.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}