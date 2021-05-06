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

import com.gwc.emp.model.LeaveRequest;
import com.gwc.emp.service.impl.LeaveRequestServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "LeaveRequestController")
@RestController
@RequestMapping("/v1/api/request")
public class LeaveRequestController 
{
	@Autowired
	LeaveRequestServiceImpl leaveRequestService;
	//return a list of all the leave requests
	@GetMapping(value="/all")
	public List <LeaveRequest> getAllRequests()
	{
		log.info("Received request to getAllProjects");

		return leaveRequestService.getAllRequests();
	}
	//retrieve a particular leave request by passing its request id 
	@GetMapping(value="/{requestId}")
	public LeaveRequest getRequestById(@PathVariable("requestId") int requestId)
	{
		log.info("Received request to getRequestById");

		return leaveRequestService.findById(requestId);
	}
	//get the list of leave requests from an employee with particular id
	//passing the employee id 
	@GetMapping(value="/emp/{employeeId}")
	public List <LeaveRequest> getRequestByEmpId(@PathVariable("employeeId") int employeeId)
	{
		log.info("Received request to getRequestByEmpId");

		return leaveRequestService.findByEmployeeId(employeeId);
	}
	//create new leave request or update existing one
	//using post method of crud repository
	@PostMapping(value="/save")
	public LeaveRequest createOrUpdate(@RequestBody LeaveRequest request)
	{
		log.info("Received request to Create or Update LeaveRequest");

		leaveRequestService.createOrUpdate(request);
		
		log.info("Execution Status - LeaveRequest created or updated successfully");
		log.info("LeaveRequest Record created : "+request.toString());

		return request;
	}
	//delete a leave request using its request id
	@DeleteMapping(value="/delete/{requestId}")
	public void delete(@PathVariable("requestId") int requestId)
	{
		log.info("Received request to Delete LeaveRequest");

		leaveRequestService.delete(requestId);
		
		log.info("Execution Status - LeaveRequest deleted successfully");
	}
}
