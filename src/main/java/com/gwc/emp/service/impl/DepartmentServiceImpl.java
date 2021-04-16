package com.gwc.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwc.emp.model.Department;
import com.gwc.emp.repository.DepartmentRepository;
import com.gwc.emp.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DepartmentServiceImpl")
@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createOrUpdate(Department department)
	{
		log.info("Executing - Creating or Updating Department");

		return departmentRepository.save(department);
	}
	
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

		List<Department> departmentList = new ArrayList<Department>();
		departmentRepository.findAll()
		                    .forEach(department -> departmentList.add(department));
		return departmentList;
	}
	
	@Override
	public Department findById (int departmentId)
	{
		log.info("Fetching Department for id - {}", departmentId);

		return departmentRepository.findById(departmentId).get();
	}
}
