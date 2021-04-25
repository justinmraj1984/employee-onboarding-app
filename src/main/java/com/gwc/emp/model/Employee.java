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
@Table(name="employees")
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empSeq")
	@SequenceGenerator(name="empSeq",sequenceName="emp_seq", allocationSize = 1)
	private int employee_id;

	private String first_name;
	private String last_name;
	private Date join_date;
	private String designation;
	private int manager_id;
	private int department_id;
	private int project_id;
	private int leave_balance; // 2 days per month

	private boolean active_flag;
	private Date created_date;
	private int created_by;
	private Date lastUpdated_date;
	private int lastUpdated_by;
}
