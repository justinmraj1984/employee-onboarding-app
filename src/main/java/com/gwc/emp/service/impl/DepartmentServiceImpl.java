package com.gwc.emp.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Department;
import com.gwc.emp.model.Employee;
import com.gwc.emp.model.request.AssignEmployeeRequest;
import com.gwc.emp.model.request.DeleteRequest;
import com.gwc.emp.model.response.DeleteResponse;
import com.gwc.emp.repository.DepartmentRepository;
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

	@Override
	public Department createOrUpdate(Department department)
	{
		log.info("Executing - Creating or Updating Department");

		return departmentRepository.save(department);
	}
	
	@Override
	public DeleteResponse delete(DeleteRequest request)
	{
		// find the department record
		String entityName = request.getEntityName();
		DeleteResponse response = new DeleteResponse();
		
		if ("Department".equals(entityName))
		{
			log.info("Executing - Delete Department");

			// find the department record
			int departmentId = request.getEntityId();
			boolean activeFlag = request.isActiveFlag();
			int deletedBy = request.getSubmittedBy();
			Date currentDate = new Date(System.currentTimeMillis());

			Department department = departmentRepository.findById(departmentId).get();

			// set values to soft delete the department record
			department.setActive_flag(activeFlag);
			department.setLastUpdated_by(deletedBy);
			department.setLastUpdated_date(currentDate);
			
			// update the department record in database
			departmentRepository.save(department);			
			
			// construct response object
			response.setStatus("SUCCESS");
			response.setMessage(entityName+"# "+departmentId+" is "+(activeFlag?"Active":"InActive"));
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
	public List<Department> getAllDepartments()
	{
		log.info("Fetching all Departments");

		List<Department> departmentList = new ArrayList<Department>();
		departmentRepository.findAll()
		                    .forEach(department -> {
		                    	if (department.isActive_flag())
		                    		departmentList.add(department);
		                    });
		return departmentList;
	}
	
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
		Date currentDate = new Date(System.currentTimeMillis());

		for (int i=0; i < empList.getEmpIdList().size(); i++)
		{
			int empId = empList.getEmpIdList().get(i);
			log.info("Assigning Employee - {} to Department - {}", empId, departmentId);
			
			employee = employeeService.findById(empId);
			employee.setDepartment_id(departmentId);
			employee.setLastUpdated_by(empList.getSubmitterId());
			employee.setLastUpdated_date(currentDate);
			employeeService.createOrUpdate(employee);
		}
	}
}
