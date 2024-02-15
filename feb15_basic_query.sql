use testDB;

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
-- FULL Join
select  *
from employee e
left join department d on e.department_id = d.department_id
UNION
select  *
from employee e
right join department d on e.department_id = d.department_id;

select  *
from employee e
cross join department d;

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




