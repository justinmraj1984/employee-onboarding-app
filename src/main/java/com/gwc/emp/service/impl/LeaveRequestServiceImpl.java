package com.gwc.emp.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Employee;
import com.gwc.emp.model.LeaveRequest;
import com.gwc.emp.repository.EmployeeRepository;
import com.gwc.emp.repository.LeaveRequestRepository;
import com.gwc.emp.service.LeaveRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "LeaveRequestServiceImpl")
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService 
{
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public LeaveRequest createOrUpdate(LeaveRequest leaveRequest)
	{
		log.info("Executing - Creating or Updating LeaveRequest");

		return leaveRequestRepository.save(leaveRequest);
	}
	
	@Override
	public void delete(int requestId)
	{
		log.info("Executing - Delete LeaveRequest");

		leaveRequestRepository.deleteById(requestId);
	}
	
	@Override
	public List<LeaveRequest> getAllRequests()
	{
		log.info("Fetching all LeaveRequests");

		List<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
		leaveRequestRepository.findAll()
		                      .forEach(request -> requestList.add(request));
		return requestList;
	}
	
	@Override
	public LeaveRequest findById (int requestId)
	{
		log.info("Fetching LeaveRequest for id - {}", requestId);

		return leaveRequestRepository.findById(requestId).get();
	}
	
	@Override
	public List <LeaveRequest> findByEmployeeId (int employeeId)
	{
		log.info("Fetching LeaveRequest for Employee ID - {}", employeeId);


		List<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
		leaveRequestRepository.findAll()
		                      .forEach(request -> {
		                    	  if (request.getSubmitter_id()==employeeId)
		                    		  requestList.add(request);
		                      });
		return requestList;
	}
	
	@Override
	public List <LeaveRequest> findByApproverId (int approverId)
	{
		log.info("Fetching LeaveRequest for Approver ID - {}", approverId);

		List<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
		leaveRequestRepository.findAll()
		                      .forEach(request -> {
		                    	  if (request.getApprover_id()==approverId)
		                    		  requestList.add(request);
		                      });
		return requestList;
	}

	@Override
	public String action (int requestId, int approverId, String approvalStatus)
	{
		log.info("Inside action");
		
		// find the request & calculate no. of days
		LeaveRequest request = leaveRequestRepository.findById(requestId).get();
		Date currentDate = new Date(System.currentTimeMillis());
		int employeeId = request.getSubmitter_id();
		int leaveDays = request.getTotal_days();
		
		// apply status
		request.setStatus(approvalStatus);
		request.setLastUpdated_by(approverId);
		request.setLastUpdated_date(currentDate);
		
		// find employee and modify leave balance if required
		Employee employee = employeeRepository.findById(employeeId).get();
		int leaveBalance = employee.getLeave_balance();
		
		// save action status and employee record
		leaveRequestRepository.save(request);
		employeeRepository.save(employee);

		return approvalStatus;
	}
	
}
