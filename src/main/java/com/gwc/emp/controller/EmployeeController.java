package com.gwc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.service.impl.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "EmployeeController")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeServiceImpl employeeService;
	
	// Fetch all the active employees in the employee table
	@GetMapping(value="/all")
	public List <Employee> getAllEmployees()
	{
		log.info("Received request to getAllEmployees");

		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value="/id/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") int employeeId)
	{
		log.info("Received request to getEmployeeById");

		return employeeService.findById(employeeId);
	}
	
	@PostMapping(value="/save")
	public Employee createOrUpdate(@RequestBody Employee employee)
	{
		log.info("Received request to Create or Update Employee");

		employeeService.createOrUpdate(employee);
		
		log.info("Execution Status - Employee created or updated successfully");
		log.info("Employee Record created : "+employee.toString());

		return employee;
	}
	
//	@DeleteMapping(value="/delete/{employeeId}")
//	public void delete(@PathVariable("employeeId") int employeeId)
//	{
//		log.info("Received request to Delete Employee");
//
//		employeeService.delete(employeeId);
//		
//		log.info("Execution Status - Employee deleted successfully");
//	}
	
	@PostMapping(value="/delete")
	public DeleteResponse delete(@RequestBody DeleteRequest request)
	{
		log.info("Received request to Delete Employee");

		return employeeService.delete(request);
		
//		log.info("Execution Status - Employee deleted successfully");
	}	
}
