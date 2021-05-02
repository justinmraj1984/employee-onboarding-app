package com.gwc.emp.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.repository.EmployeeRepository;
import com.gwc.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "EmployeeServiceImpl")
@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createOrUpdate(Employee employee)
	{
		log.info("Executing - Creating or Updating Employee");
		
		// Calculate total leave balance for the employee
		LocalDate currentDate = LocalDate.now();
		LocalDate joinDate = employee.getJoin_date().toLocalDate();
		int LASTMONTHOFYEAR = 12;
		int leaveCalculationMonth = (currentDate.getYear() <= joinDate.getYear()) ? joinDate.getMonthValue() : 0;
		
		int remainingMonths = LASTMONTHOFYEAR - leaveCalculationMonth;
		int leaveBalance = remainingMonths * 2;

		log.info("currentDate - {}   joinDate - {}   leaveCalculationMonth - {}", currentDate, joinDate, leaveCalculationMonth);
		log.info("remainingMonths - {}   leaveBalance - {}", remainingMonths, leaveBalance);
		
		if (leaveBalance > 0)
			employee.setLeave_balance(leaveBalance);
		
		log.info("Leave balance : {}", leaveBalance);

		return employeeRepository.save(employee);
	}
	
//	@Override
//	public void delete(int employeeId)
//	{
//		log.info("Executing - Delete Employee");
//
//		employeeRepository.deleteById(employeeId);
//	}
	
	@Override
	public DeleteResponse delete(DeleteRequest request)
	{
		// find the employee record
		String entityName = request.getEntityName();
		DeleteResponse response = new DeleteResponse();
		
		if ("Employee".equals(entityName))
		{
			log.info("Executing - Delete Employee");

			// find the employee record
			int employeeId = request.getEntityId();
			boolean activeFlag = request.isActiveFlag();
			int deletedBy = request.getSubmittedBy();
			Date currentDate = new Date(System.currentTimeMillis());

			Employee employee = employeeRepository.findById(employeeId).get();

			// set values to soft delete the employee record
			employee.setActive_flag(activeFlag);
			employee.setLastUpdated_by(deletedBy);
			employee.setLastUpdated_date(currentDate);
			
			// update the employee record in database
			employeeRepository.save(employee);
			
			// construct response object
			response.setStatus("SUCCESS");
			response.setMessage(entityName+"# "+employeeId+" is "+(activeFlag?"Active":"InActive"));
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
	public List<Employee> getAllEmployees()
	{
		log.info("Fetching all Employees");

		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.findAll()
		                  .forEach(employee -> {
		                	  if (employee.isActive_flag())
		                		  employeeList.add(employee);
		                  });
		return employeeList;
	}
	
	@Override
	public Employee findById (int employeeId)
	{
		log.info("Fetching Employee for id - {}", employeeId);

		return employeeRepository.findById(employeeId).get();
	}
}
