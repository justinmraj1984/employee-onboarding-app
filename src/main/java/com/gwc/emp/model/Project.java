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
@Table(name="projects")
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prjSeq")
	@SequenceGenerator(name="prjSeq",sequenceName="prj_seq", allocationSize = 1)
	private int project_id;

	private String project_name;
	private String description;
	private Date start_date;
	private Date end_date;
	private String status;  // IN_PROGRESS, COMPLETED
	private int manager_id;
	private int department_id;

	private boolean active_flag;
	private Date created_date;
	private int created_by;
	private Date lastUpdated_date;
	private int lastUpdated_by;
}
