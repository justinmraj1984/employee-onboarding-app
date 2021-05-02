package com.gwc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwc.emp.model.Department;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.service.impl.DepartmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DepartmentController")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController 
{
	@Autowired
	DepartmentServiceImpl departmentService;
	
	@GetMapping(value="/all")
	public List <Department> getAllDepartments()
	{
		log.info("Received request to getAllDepartments");

		return departmentService.getAllDepartments();
	}
	
	@GetMapping(value="/id/{departmentId}")
	public Department getDepartmentById(@PathVariable("departmentId") int departmentId)
	{
		log.info("Received request to getDepartmentById");

		return departmentService.findById(departmentId);
	}
	
	@PostMapping(value="/save", consumes = "application/json", produces = "application/json")
	public Department createOrUpdate(@RequestBody Department department)
	{
		log.info("Received request to Create or Update Department");

		departmentService.createOrUpdate(department);
		
		log.info("Execution Status - Department created or updated successfully");
		log.info("Department Record created : "+department.toString());

		return department;
	}
	
	@PostMapping(value="/delete")
	public DeleteResponse delete(@RequestBody DeleteRequest request)
	{
		log.info("Received request to Delete Department");

		return departmentService.delete(request);
	}

	@PostMapping(value="/assign/{departmentId}")
	public void assign( @PathVariable("departmentId") int departmentId
			          , @RequestBody AssignEmployeeRequest empList)
	{
		log.info("Received request to Assign employees to Department");

		departmentService.assign(departmentId, empList);
	}

}
