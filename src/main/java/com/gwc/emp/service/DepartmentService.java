package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Department;

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
}
