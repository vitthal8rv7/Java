use testDB;

-- Joins
-- ----------------

-- Get employees, departments details who have any department. 
-- Inner Join
select  e.employee_id, e.name, e.department_id
from employee e
inner join department d on e.department_id = d.department_id;

-- Get all employees and departments who have any employee. 
-- LEFT Join
select  *
from employee e
left join department d on e.department_id = d.department_id;

-- Get all departments and employees who have any department. 
-- RIGHT Join
select  *
from employee e
right join department d on e.department_id = d.department_id;

-- Get all departments and all employees.
-- FULL Join in mysql
select  *
from employee e
left join department d on e.department_id = d.department_id
UNION
select  *
from employee e
right join department d on e.department_id = d.department_id;

-- cross join
select  *
from employee e
cross join department d;

-- natural join
select  *
from employee e
natural join department d;




--  self join not understood well
ALTER TABLE department ADD parent varchar(255);
SET SQL_SAFE_UPDATES = 0; -- uncheck/disable safe update
update department set parent = 'HR';
update department set parent = 'HR' WHERE  department.name = 'IT' OR department.name = 'HR';
update department set parent = 'Sales' WHERE  department.name != 'IT' AND department.name != 'HR';

SET SQL_SAFE_UPDATES = 1; -- After update check/enable safe update again

select  newD.name, newD2.name
from (select distinct name from department) newD
join (select distinct parent from department) newD2  on newD.name = newD2.parent;

select  d.department_id, d.name, d.parent, dself.parent parent_dself
from department d
join department dself on dself.parent = d.parent; -- (select distinct department.parent from department);

select  d.name, d.parent
from  department d
join (select name from department group by name) d2
on d2.name = d.parent ORDER BY d.name;

--  self join basic working...
select *
from department d
join department d2
on d.department_id = d2.department_id;

select *
from department d
left join department d2
on d.name = d2.department_id;

select *
from department d
right join department d2
on d.name = d2.department_id;

-- end self join



-- SubQuery
-- ---------------------

-- Scalar Subquery 

-- list all employees along with max salary among them with each employee.
select name emp_name, (select max(salary) from employee)as max_salary from employee;

-- list all employees who have max salary.
select name emp_name, salary from employee where salary >= (select max(salary) from employee);

-- list all employees who have max salary.
select e.name emp_name, e.salary 
from employee e
join (select max(salary) max_sal from employee) e
on e.max_sal <= e.salary;

-- Multi Row SubQuery
select department_id, name, location 
from department 
where department.department_id IN (select department_id from department where department.location = 'new york');


-- scalar subquery
select e.employee_id, department.department_id, e.name, department.name, e.salary
from employee e 
join department 
on department.department_id = e.department_id and e.salary > (select max(e.salary) as max_sala 
from employee e, department 
where department.department_id = e.department_id and department.name = 'Sales');


-- multi row subquery
select * from (select department.name, max(e.salary) as max_sala
from employee e, department 
where department.department_id = e.department_id  group by department.name) as new;



-- With Clause
WITH DepartmentTotals AS (
    SELECT department_id, SUM(salary) AS total_salary
    FROM employee
    GROUP BY department_id
)
SELECT department_id, DepartmentTotals.total_salary
FROM DepartmentTotals;

-- with
with max_salary_of_hr_department as (
select max(e.salary) as max_sal 
from employee e, department 
where department.department_id = e.department_id and department.name = 'HR')
SELECT max_salary_of_hr_department.max_sal
FROM max_salary_of_hr_department;

with max_salary_of_hr_department as (
select max(e.salary) as max_sal 
from employee e, department 
where department.department_id = e.department_id and department.name = 'HR')
select e.employee_id, e.name, e.salary
from employee e 
join max_salary_of_hr_department 
on e.salary > max_salary_of_hr_department.max_sal;


-- having clause
select department.name, count(department.name) as number_of_entries
from employee e, department 
where department.department_id = e.department_id
group by department.name having number_of_entries > 5;

-- ---
select department.name
from employee e, department 
where department.department_id = e.department_id;

select sum(number_of_entries) as total from (select count(department.name) as number_of_entries
from employee e, department 
where department.department_id = e.department_id
group by department.name having number_of_entries > 4) as sumTable;






