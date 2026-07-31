select e.name as Employee from Employee as e where exists(
    select 1 from Employee m
    where e.managerId=m.Id 
    and e.salary >m.salary
);