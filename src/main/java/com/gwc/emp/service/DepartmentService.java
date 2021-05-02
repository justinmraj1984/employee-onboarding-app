package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Department;
import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;

public interface DepartmentService 
{
	// Create or Update Department
	Department createOrUpdate(Department department);

	// Delete Department
	DeleteResponse delete (DeleteRequest request);

	// Fetch all Departments
	List <Department> getAllDepartments();

	// Search Department
	Department findById (int departmentId);
	
	// Assign Employees to Department
	void assign (int departmentId, AssignEmployeeRequest empList);

}
