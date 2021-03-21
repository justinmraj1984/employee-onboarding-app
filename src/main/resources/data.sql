-- DROP TABLE IF EXISTS employees;
-- DROP TABLE IF EXISTS departments;
-- DROP TABLE IF EXISTS projects;
-- DROP TABLE IF EXISTS project_assignments;
-- DROP TABLE IF EXISTS leave_requests;

CREATE TABLE employees 
( emp_id INT AUTO_INCREMENT PRIMARY KEY
, first_name VARCHAR(250) NOT NULL
, last_name VARCHAR(250) NOT NULL
, date_of_birth DATE NOT NULL
, date_of_join DATE NOT NULL
, designation VARCHAR(250) NOT NULL
, dept_id INT
, project_id INT
, leave_balance_days INT -- 2 days per month
, created_date DATE
, created_by INT
, last_update_date DATE
, last_update_by INT
);

CREATE TABLE departments
( dept_id INT AUTO_INCREMENT PRIMARY KEY
, dept_name VARCHAR(250) NOT NULL
, mgr_id INT
, created_date DATE
, created_by INT
, last_update_date DATE
, last_update_by INT
);

CREATE TABLE projects
( prj_id INT AUTO_INCREMENT PRIMARY KEY
, prj_name VARCHAR(250) NOT NULL
, mgr_id INT
, prj_start_date DATE
, prj_end_date DATE
, prj_status VARCHAR(50) -- IN_PROGRESS, COMPLETED
, created_date DATE
, created_by INT
, last_update_date DATE
, last_update_by INT
);

CREATE TABLE project_assignments
( prj_id INT NOT NULL
, emp_id INT NOT NULL
, emp_join_date DATE
, emp_last_date DATE
, created_date DATE
, created_by INT
, last_update_date DATE
, last_update_by INT
);

CREATE TABLE leave_requests
( request_id INT AUTO_INCREMENT PRIMARY KEY
, emp_id INT NOT NULL
, leave_start_date DATE NOT NULL
, leave_end_date DATE NOT NULL
, leave_status VARCHAR(250) -- PENDING, APPROVED, REJECTED, CANCELLED
, approver_id INT
, created_date DATE
, created_by INT
, last_update_date DATE
, last_update_by INT
);


INSERT INTO TABLE employees 
( first_name, last_name, date_of_birth, date_of_join, designation, created_date, last_update_date )
VALUES
  ( 'Brownie', 'Giles', '01-JAN-1970', '01-JAN-2010', 'CEO', SYSDATE, SYSDATE )
, ( 'Amber', 'Fox', '01-JAN-1970', '01-JAN-2010', 'CIO', SYSDATE, SYSDATE )
, ( 'Trudy', 'Winter', '01-JAN-1970', '01-JAN-2010', 'HR Manager', SYSDATE, SYSDATE );

INSERT INTO TABLE departments
( dept_name, mgr_id )
VALUES
  ( 'Administration', 1 )
, ( 'Information Technology', 2)
, ( 'Human Resources', 3);

INSERT INTO TABLE projects
( prj_name, mgr_id, prj_start_date, prj_end_date, prj_status )
VALUES
, ( 'Data Science Project', 2, '01-JAN-2020', '31-DEC-2022', 'IN_PROGRESS' )
, ( 'Banking Project', 2, '01-JAN-2021', '31-DEC-2025', 'IN_PROGRESS' );
