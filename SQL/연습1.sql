select * from book;

select * from customer;

select * from orders;

select * from emp;



select job, deptno as dno,
nvl(decode(deptno, 10, sum(sal)),0) as "부서10",
--decode(deptno, 10, sum(sal)) as "부서10",
nvl(decode(deptno, 20, sum(sal)),0) as "부서20",
nvl(decode(deptno, 30, sum(sal)),0) as "부서30",
sum(sal) as "총액"
from emp 
group by job, deptno 
order by job, deptno
;


create table emp31
as
select * from emp;

create table dept31
as
select * from dept;

create table dept32
as
select * from dept;

commit;
