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
@Table(name="project_assignments")
public class ProjectAssignment 
{
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="prjAssignSeq")
	@SequenceGenerator(name="prjAssignSeq",sequenceName="prj_assign_seq", allocationSize = 1)
	private int assignment_id;

	private int project_id;
	private int employee_id;
	private int department_id;
	private Date emp_join_date;
	private Date emp_last_date;

	private boolean active_flag;
	private Date created_date;
	private int created_by;
	private Date lastUpdated_date;
	private int lastUpdated_by;
}
