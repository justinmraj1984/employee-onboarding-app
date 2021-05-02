package com.gwc.emp.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Employee;
import com.gwc.emp.model.Project;
import com.gwc.emp.model.ProjectAssignment;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.repository.ProjectRepository;
import com.gwc.emp.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ProjectServiceImpl")
@Service
public class ProjectServiceImpl implements ProjectService 
{
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectAssignmentServiceImpl projectAssignmentService;
	@Autowired
	private EmployeeServiceImpl employeeService;

	@Override
	public Project createOrUpdate(Project project)
	{
		log.info("Executing - Creating or Updating Project");

		return projectRepository.save(project);
	}
	
	@Override
	public DeleteResponse delete(DeleteRequest request)
	{
		// find the project record
		String entityName = request.getEntityName();
		DeleteResponse response = new DeleteResponse();

		if ("Project".equals(entityName))
		{
			log.info("Executing - Delete Project");

			// find the project record
			int projectId = request.getEntityId();
			boolean activeFlag = request.isActiveFlag();
			int completedBy = request.getSubmittedBy();
			Date currentDate = new Date(System.currentTimeMillis());

			Project project = projectRepository.findById(projectId).get();

			// set values to soft delete the department record
			project.setActive_flag(activeFlag);
			project.setEnd_date(currentDate);
			project.setLastUpdated_by(completedBy);
			project.setLastUpdated_date(currentDate);

			// update the department record in database
			projectRepository.save(project);
			
			// construct response object
			response.setStatus("SUCCESS");
			response.setMessage(entityName+"# "+projectId+" is "+(activeFlag?"Open":"Completed"));
		}
		else
		{
			log.error("Invalid Entity");
			response.setStatus("ERROR");
			response.setMessage("Invalid Entity");
		}
		
		return response;
	}

	
	@Override
	public List<Project> getAllProjects()
	{
		log.info("Fetching all Projects");

		List<Project> projectList = new ArrayList<Project>();
		projectRepository.findAll()
		                 .forEach(project -> projectList.add(project));
		return projectList;
	}
	
	@Override
	public Project findById (int projectId)
	{
		log.info("Fetching Project for id - {}", projectId);

		return projectRepository.findById(projectId).get();
	}
	
	
	@Override
	public void assign (int projectId, AssignEmployeeRequest empList)
	{
		log.info("Assigning Employees {} to Project - {}", empList.getEmpIdList().toString(), projectId);

		Employee employee = new Employee();
		ProjectAssignment newAssignment = new ProjectAssignment();
		Date currentDate = new Date(System.currentTimeMillis());

		for (int i=0; i < empList.getEmpIdList().size(); i++)
		{
			int empId = empList.getEmpIdList().get(i);
			int submitterId = empList.getSubmitterId();
			log.info("Assigning Employee - {} to Project - {}", empId, projectId);
			
			// Identify the employee record
			employee = employeeService.findById(empId);
			
			// Assign Project Id to the Employee record
			employee.setProject_id(projectId);
			employeeService.createOrUpdate(employee);

			// Add new record to the Project Assignments table
			newAssignment.setProject_id(projectId);
			newAssignment.setEmployee_id(empId);
			newAssignment.setDepartment_id(employee.getDepartment_id());
			newAssignment.setEmp_join_date(currentDate);
			newAssignment.setActive_flag(true);
			newAssignment.setCreated_by(submitterId);
			newAssignment.setLastUpdated_by(submitterId);
			newAssignment.setCreated_date(currentDate);
			newAssignment.setLastUpdated_date(currentDate);
			projectAssignmentService.save(newAssignment);
		}
	}
}
