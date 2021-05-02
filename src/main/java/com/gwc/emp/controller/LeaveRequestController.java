package com.gwc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwc.emp.model.LeaveRequest;
import com.gwc.emp.model.request.LeaveApprovalRequest;
import com.gwc.emp.service.impl.LeaveRequestServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "LeaveRequestController")
@RestController
@RequestMapping("/api/v1/request")
public class LeaveRequestController 
{
	@Autowired
	LeaveRequestServiceImpl leaveRequestService;
	
	@GetMapping(value="/all")
	public List <LeaveRequest> getAllRequests()
	{
		log.info("Received request to getAllProjects");

		return leaveRequestService.getAllRequests();
	}
	
	@GetMapping(value="/id/{requestId}")
	public LeaveRequest getRequestById(@PathVariable("requestId") int requestId)
	{
		log.info("Received request to getRequestById");

		return leaveRequestService.findById(requestId);
	}
	
	@GetMapping(value="/employee/{employeeId}")
	public List <LeaveRequest> getRequestByEmpId(@PathVariable("employeeId") int employeeId)
	{
		log.info("Received request to getRequestByEmpId");

		return leaveRequestService.findByEmployeeId(employeeId);
	}
	
	@GetMapping(value="/approver/{approverId}")
	public List <LeaveRequest> getRequestByApproverId(@PathVariable("approverId") int approverId)
	{
		log.info("Received request to getRequestByApproverId");

		return leaveRequestService.findByApproverId(approverId);
	}
	
	@PostMapping(value="/save")
	public LeaveRequest createOrUpdate(@RequestBody LeaveRequest request)
	{
		log.info("Received request to Create or Update LeaveRequest");

		leaveRequestService.createOrUpdate(request);
		
		log.info("Execution Status - LeaveRequest created or updated successfully");
		log.info("LeaveRequest Record created : "+request.toString());

		return request;
	}
	
	@PostMapping(value="/action")
	public String action(@RequestBody LeaveApprovalRequest request)
	{
		log.info("Received request to Approve or Reject LeaveRequest");

		int requestId = request.getRequestId(); 
		int approverId = request.getApproverId();
		String approvalStatus = request.getApprovalStatus();
		
		String actionStatus = leaveRequestService.action(requestId, approverId, approvalStatus);

		log.info("LeaveRequest - {} is {} by Approver {}", requestId, actionStatus, approverId);

		return actionStatus;
	}
}
