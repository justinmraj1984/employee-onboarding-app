package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;

public interface EmployeeService 
{
	// Create or Update Employee
	Employee createOrUpdate(Employee employee);

	// Delete Employee
	//void delete (int employeeId);
	DeleteResponse delete (DeleteRequest request);

	// Fetch all Employees
	List <Employee> getAllEmployees();

	// Search Employee
	Employee findById (int employeeId);
}
