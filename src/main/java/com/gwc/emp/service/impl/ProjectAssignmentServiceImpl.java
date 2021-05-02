package com.gwc.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Project;
import com.gwc.emp.model.ProjectAssignment;
import com.gwc.emp.repository.ProjectAssignmentRepository;
import com.gwc.emp.service.ProjectAssignmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ProjectAssignmentServiceImpl")
@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService 
{
	@Autowired
	private ProjectAssignmentRepository projectAssignmentRepository;

	@Override
	public ProjectAssignment save(ProjectAssignment assignment)
	{
		log.info("Executing - Project Assignment update");

		return projectAssignmentRepository.save(assignment);
	}
		
	@Override
	public List<ProjectAssignment> getAllAssignments()
	{
		log.info("Fetching all ProjectAssignments");

		List<ProjectAssignment> projectAssignmentList = new ArrayList<ProjectAssignment>();
		projectAssignmentRepository.findAll()
		                 .forEach(projectAssignment -> projectAssignmentList.add(projectAssignment));
		return projectAssignmentList;
	}
	
	@Override
	public List <ProjectAssignment> findAssignmentsByProject (int projectId)
	{
		log.info("Fetching Assignments for Project ID - {}", projectId);

		return null;
//		return projectAssignmentRepository.findById(assignmentId).get();
	}
}
