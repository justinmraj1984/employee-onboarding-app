package com.gwc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwc.emp.model.ProjectAssignment;
import com.gwc.emp.service.impl.ProjectAssignmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ProjectAssignmentController")
@RestController
@RequestMapping("/v1/api/assignment")
public class ProjectAssignmentController 
{
	@Autowired
	ProjectAssignmentServiceImpl projectAssignmentService;
	
	@GetMapping(value="/all")
	public List <ProjectAssignment> getAllAssignments()
	{
		log.info("Received request to getAllAssignments");

		return projectAssignmentService.getAllAssignments();
	}

	@GetMapping(value="/project/{projectId}")
	public List <ProjectAssignment> getAssignmentsByProject(@PathVariable("projectId") int projectId)
	{
		log.info("Received request to findAssignmentsByProjectId");

		return projectAssignmentService.findAssignmentsByProject(projectId);
	}
	
}
