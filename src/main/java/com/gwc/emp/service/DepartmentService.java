package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Department;
import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.AssignEmployeeRequest;

public interface DepartmentService 
{
	// Create or Update Department
	Department createOrUpdate(Department department);

	// Delete Department
	void delete (int departmentId);

	// Fetch all Departments
	List <Department> getAllDepartments();

	// Search Department
	Department findById (int departmentId);
	
	// Assign Employees to Department
	void assign (int departmentId, AssignEmployeeRequest empList);

}
