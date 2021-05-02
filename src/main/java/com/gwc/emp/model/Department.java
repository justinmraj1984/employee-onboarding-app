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
@Table(name="departments")
public class Department 
{
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="deptSeq")
	@SequenceGenerator(name="deptSeq",sequenceName="dept_seq", allocationSize = 1)
	private int department_id;

	private String department_name;
	private int manager_id;
	private boolean active_flag;
	private Date created_date;
	private int created_by;
	private Date lastUpdated_date;
	private int lastUpdated_by;
}
