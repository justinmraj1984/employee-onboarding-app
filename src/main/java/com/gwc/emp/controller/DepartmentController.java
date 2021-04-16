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

import com.gwc.emp.model.Department;
import com.gwc.emp.service.impl.DepartmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DepartmentController")
@RestController
@RequestMapping("/api/department")
public class DepartmentController 
{
	@Autowired
	DepartmentServiceImpl departmentService;
	
	@GetMapping(value="/")
	public List <Department> getAllDepartments()
	{
		log.info("Received request to getAllDepartments");

		return departmentService.getAllDepartments();
	}
	
	@GetMapping(value="/{departmentId}")
	public Department getDepartmentById(@PathVariable("departmentId") int departmentId)
	{
		log.info("Received request to getDepartmentById");

		return departmentService.findById(departmentId);
	}
	
	@PostMapping(value="/save")
	public Department createOrUpdate(@RequestBody Department department)
	{
		log.info("Received request to Create or Update Department");

		departmentService.createOrUpdate(department);
		
		log.info("Execution Status - Department created or updated successfully");

		return department;
	}
	
	@DeleteMapping(value="/delete/{departmentId}")
	public void delete(@PathVariable("departmentId") int departmentId)
	{
		log.info("Received request to Delete Department");

		departmentService.delete(departmentId);
		
		log.info("Execution Status - Department deleted successfully");
	}
	
}
