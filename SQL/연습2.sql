-- 2020.06.01. 월요일.

create table emp21
as
select * from emp;

create table dept21
as
select * from dept;


desc tab;

insert into dept values(77, "ACCOUNTING", "LONDON");


--3번
update dept02
set dname='DESIGN', loc='FRANCE'
where deptno=77;

delete dept02
set dname='DESIGN', loc='FRANCE'
where deptno=77;

create view emp_view22
as
select *
from emp21 natural join dept21;


select * from tab;

delete from dept
where deptno=77;

select * from dept21;

create index emp_index on emp (ename);



select * from emp21;

update emp
set deptno = (select deptno from emp where ename='SCOTT');



select * from emp21 ;

select * from user_constraints;



