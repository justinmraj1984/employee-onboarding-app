package com.gwc.emp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="leave_requests")
public class LeaveRequest 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="requestSeq")
	@SequenceGenerator(name="requestSeq",sequenceName="leave_req_seq", allocationSize = 1)
	private int request_id;

	private int submitter_id;
	private int approver_id;
	private Date leave_start_date;
	private Date leave_end_date;
	private int total_days;
	private String status;  // PENDING, APPROVED, REJECTED, CANCELLED

	private boolean active_flag;
	private Date created_date;
	private int created_by;
	private Date lastUpdated_date;
	private int lastUpdated_by;
}
