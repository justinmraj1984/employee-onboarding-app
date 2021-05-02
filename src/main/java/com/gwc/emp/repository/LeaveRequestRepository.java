package com.gwc.emp.repository;

import org.springframework.data.repository.CrudRepository;
import com.gwc.emp.model.LeaveRequest;

public interface LeaveRequestRepository extends CrudRepository<LeaveRequest, Integer>
{

}
