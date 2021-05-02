package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Project;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;

public interface ProjectService 
{
	// Create or Update Project
	Project createOrUpdate(Project project);

	// Delete Project
	DeleteResponse delete (DeleteRequest request);

	// Fetch all Projects
	List <Project> getAllProjects();

	// Search Project
	Project findById (int projectId);
	
	// Assign Employees to the Project and create Project Assignment
	void assign (int projectId, AssignEmployeeRequest empList);
}
