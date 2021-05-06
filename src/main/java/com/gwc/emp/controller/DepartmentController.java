package com.gwc.emp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.service.impl.DepartmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DepartmentController")
@RestController
@RequestMapping("/v1/api/department")
public class DepartmentController 
{
	@Autowired
	DepartmentServiceImpl departmentService;
	//get list of all the department details 
	@GetMapping(value="/all")
	public List <Department> getAllDepartments()
	{
		log.info("Received request to getAllDepartments");

		return departmentService.getAllDepartments();
	}
	//get the department details by passing dept id
	@GetMapping(value="/id/{departmentId}")
	public Department getDepartmentById(@PathVariable("departmentId") int departmentId)
	{
		log.info("Received request to getDepartmentById");

		return departmentService.findById(departmentId);
	}
	// creating new dept or updating existing one from request
	@PostMapping(value="/save")
	public Department createOrUpdate(@RequestBody Department department)
	{
		log.info("Received request to Create or Update Department");

		departmentService.createOrUpdate(department);
		
		log.info("Execution Status - Department created or updated successfully");
		log.info("Department Record created : "+department.toString());

		return department;
	}
	//delete dept by passing its id 
	@DeleteMapping(value="/delete/{departmentId}")
	public void delete(@PathVariable("departmentId") int departmentId)
	{
		log.info("Received request to Delete Department");

		departmentService.delete(departmentId);
		
		log.info("Execution Status - Department deleted successfully");
	}
	//assign employee from employee list to dept based on dept id
	@PostMapping(value="/assign/{departmentId}")
	public void assign( @PathVariable("departmentId") int departmentId, @RequestBody AssignEmployeeRequest empList)
	{
		log.info("Received request to Assign employees to Department");

		departmentService.assign(departmentId, empList);
	}
	@GetMapping(value="/hello")
	public String hello(String name)
	{
		log.info("User message printed");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		return name+" accessed Swigger at "+dtf.format(now);
	}

}
