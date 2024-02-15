use testDB;
select e.employee_id, e.department_id, d.department_id, e.name, d.name 
from employee e
join department d on e.department_id = d.department_id;


