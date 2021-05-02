package com.gwc.emp.repository;

import org.springframework.data.repository.CrudRepository;
import com.gwc.emp.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>
{

}
