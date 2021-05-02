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

	// Search ProjectAssignment
	List <ProjectAssignment> findAssignmentsByProject (int projectId);
}
