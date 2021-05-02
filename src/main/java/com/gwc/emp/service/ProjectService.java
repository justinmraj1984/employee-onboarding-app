package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Project;
import com.gwc.emp.model.request.AssignEmployeeRequest;

public interface ProjectService 
{
	// Create or Update Project
	Project createOrUpdate(Project project);

	// Delete Project
	void delete (int projectId);

	// Fetch all Projects
	List <Project> getAllProjects();

	// Search Project
	Project findById (int projectId);
	
	// Assign Employees to the Project and create Project Assignment
	void assign (int projectId, AssignEmployeeRequest empList);
}
