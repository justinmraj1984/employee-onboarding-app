package com.gwc.emp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Department 
{
	@Id
	@GeneratedValue
	private int departmentId;

	private String departmentName;
	private int managerId;
	private boolean activeFlag;
	private Date createdDate;
	private int createdBy;
	private Date lastUpdatedDate;
	private int lastUpdatedBy;
}
