package com.gwc.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.LeaveRequest;
import com.gwc.emp.repository.LeaveRequestRepository;
import com.gwc.emp.service.LeaveRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "LeaveRequestServiceImpl")
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService 
{
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

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

		return null;
//		return leaveRequestRepository.findByEmployeeId(employeeId).get();
	}
}