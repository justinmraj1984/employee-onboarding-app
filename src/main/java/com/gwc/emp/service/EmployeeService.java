package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Employee;

public interface EmployeeService 
{
	// Create or Update Employee
	Employee createOrUpdate(Employee employee);

	// Delete Employee
	void delete (int employeeId);

	// Fetch all Employees
	List <Employee> getAllEmployees();

	// Search Employee
	Employee findById (int employeeId);
}
