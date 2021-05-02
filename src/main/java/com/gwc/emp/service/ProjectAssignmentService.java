package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.Project;
import com.gwc.emp.model.ProjectAssignment;

public interface ProjectAssignmentService 
{
	// Save Project Assignment
	ProjectAssignment save(ProjectAssignment assignment);
	
	// Fetch all ProjectAssignments
	List <ProjectAssignment> getAllAssignments();

	// Search ProjectAssignments by Project Id
	List <ProjectAssignment> findAssignmentsByProject (int projectId);

	// Search ProjectAssignments by Employee Id
	List <ProjectAssignment> findAssignmentsForEmployee (int employeeId);
}
