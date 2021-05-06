package com.gwc.emp.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Department;
import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.repository.DepartmentRepository;
import com.gwc.emp.repository.EmployeeRepository;
import com.gwc.emp.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DepartmentServiceImpl")
@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeServiceImpl employeeService;
	//save the new dept or save the update to dept
	@Override
	public Department createOrUpdate(Department department)
	{
		log.info("Executing - Creating or Updating Department");

		return departmentRepository.save(department);
	}
	//delete a dept by its dept id
	@Override
	public void delete(int departmentId)
	{
		log.info("Executing - Delete Department");

		departmentRepository.deleteById(departmentId);
	}
	
	@Override
	public List<Department> getAllDepartments()
	{
		log.info("Fetching all Departments");
		//create a list of department objects
		List<Department> departmentList = new ArrayList<Department>();
		departmentRepository.findAll()
		                    .forEach(department -> departmentList.add(department));
		return departmentList;
	}
	//find the department based on its id
	@Override
	public Department findById (int departmentId)
	{
		log.info("Fetching Department for id - {}", departmentId);

		return departmentRepository.findById(departmentId).get();
	}
	
	@Override
	public void assign (int departmentId, AssignEmployeeRequest empList)
	{

		log.info("Assigning Employees {} to Department - {}", empList.getEmpIdList().toString(), departmentId);
		
		Employee employee = new Employee();
		//create date object with value as current time in milliseconds
		Date currentDate = new Date(System.currentTimeMillis());
		//repeat till all employees in employee list is in a dept
		for (int i=0; i < empList.getEmpIdList().size(); i++)
		{
			int empId = empList.getEmpIdList().get(i);
			log.info("Assigning Employee - {} to Department - {}", empId, departmentId);
			
			employee = employeeService.findById(empId);
			employee.setDepartment_id(departmentId);
			employee.setLastUpdated_by(empList.getSubmitterId());
			//set current date as last updated date
			employee.setLastUpdated_date(currentDate);
			employeeService.createOrUpdate(employee);
		}
	}
}
