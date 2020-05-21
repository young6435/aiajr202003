-- 2020.05.21. 목요일.

-- join

select * from emp;      -- 14행

select * from dept;     -- 4행,  

-- cross join

select *                     --  14 x 4 => 56행 나온다.
from emp, dept
;       


select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;

select e.ename, d.dname, e.deptno, d.deptno
from emp e, dept d          -- 별칭사용.
where e.deptno = d.deptno
;


-- book, customer, orders
select * from orders;
select * from book;
select * from customer;

-- cross join

select *                
from orders o, book b, customer c       -- 10 x 10 x 5 = 500행
where o.bookid = b.bookid and o.custid = c.custid
;

select *                
from orders o, book b, customer c       -- 10 x 10 x 5 = 500행
where o.bookid = b.bookid and o.custid = c.custid and name = '박지성'
;