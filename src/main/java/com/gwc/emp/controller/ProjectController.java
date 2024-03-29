package com.gwc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwc.emp.model.Project;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.service.impl.ProjectServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ProjectController")
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController 
{
	@Autowired
	ProjectServiceImpl projectService;
	
	@GetMapping(value="/all")
	public List <Project> getAllProjects()
	{
		log.info("Received request to getAllProjects");

		return projectService.getAllProjects();
	}
	
	@GetMapping(value="/id/{projectId}")
	public Project getProjectById(@PathVariable("projectId") int projectId)
	{
		log.info("Received request to getProjectById");

		return projectService.findById(projectId);
	}
	
	@PostMapping(value="/save")
	public Project createOrUpdate(@RequestBody Project project)
	{
		log.info("Received request to Create or Update Project");

		projectService.createOrUpdate(project);
		
		log.info("Execution Status - Project created or updated successfully");
		log.info("Project Record created : "+project.toString());

		return project;
	}
	
	@PostMapping(value="/complete")
	public DeleteResponse complete(@RequestBody DeleteRequest request)
	{
		log.info("Received request to Delete Project");

		return projectService.delete(request);
	}
	
	@PostMapping(value="/assign/{projectId}")
	public void assign( @PathVariable("projectId") int projectId
			          , @RequestBody AssignEmployeeRequest empIdList)
	{
		log.info("Received request to Assign employees to Project");

		projectService.assign(projectId, empIdList);
	}

}
