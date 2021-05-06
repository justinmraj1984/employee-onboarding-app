package com.gwc.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Employee;
import com.gwc.emp.repository.EmployeeRepository;
import com.gwc.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "EmployeeServiceImpl")
@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	//creating new employee or updating existing employee
	@Override
	public Employee createOrUpdate(Employee employee)
	{
		log.info("Executing - Creating or Updating Employee");

		return employeeRepository.save(employee);
	}
	//delete employee record by their id
	@Override
	public void delete(int employeeId)
	{
		log.info("Executing - Delete Employee");

		employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public List<Employee> getAllEmployees()
	{
		log.info("Fetching all Employees");
		//create a list of all the employees
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.findAll()
		                  .forEach(employee -> employeeList.add(employee));
		return employeeList;
	}
	//find the employee record by their id
	@Override
	public Employee findById (int employeeId)
	{
		log.info("Fetching Employee for id - {}", employeeId);

		return employeeRepository.findById(employeeId).get();
	}
}
