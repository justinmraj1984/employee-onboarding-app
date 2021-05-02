package com.gwc.emp.service;

import java.util.List;

import com.gwc.emp.model.LeaveRequest;

public interface LeaveRequestService 
{
	// Create or Update LeaveRequest
	LeaveRequest createOrUpdate(LeaveRequest request);

	// Delete LeaveRequest
	void delete (int requestId);

	// Fetch all LeaveRequests
	List <LeaveRequest> getAllRequests();

	// Search LeaveRequest
	LeaveRequest findById (int requestId);

	// Search LeaveRequest by Employee ID
	List <LeaveRequest> findByEmployeeId (int employeeId);
}
