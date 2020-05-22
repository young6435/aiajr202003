-- 2020.05.21. 목요일.

-- join

select * from emp;      -- 14행

select * from dept;     -- 4행,  

-- cross join

select *                     --  14 x 4 => 56행 나온다.
from emp, dept
;

select *
from emp cross join dept
;


select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;


select *
from emp inner join dept
on emp.deptno = dept.deptno
;


select ename, dname
from emp e inner join dept d
on e.deptno = d.deptno
;


select ename, dname
from emp inner join dept
using(deptno)               -- emp, dept테이블에서 deptno가 공통이다.
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
where o.bookid = b.bookid and o.custid = c.custid       -- 책이름, 고객번호
;

select *                
from orders o, book b, customer c       -- 10 x 10 x 5 = 500행
where o.bookid = b.bookid and o.custid = c.custid and name = '박지성'
;


--------------------------------------------------------

select * from emp;
select * from salgrade;


select ename, sal, grade        -- sal이 어떤 등급(grade) 이냐.
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
;

select ename, sal, grade
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between losal and hisal   -- sal이 losal 이상이고 hisal 이하다.
;

----------------------------------------------------------

-- self join

-- 관리자의 이름을 알아보자.

select * from emp;


select e.ename || ' 의 상사는 ' || m.ename || ' 입니다. '
from emp e, emp m
where e.mgr = m.empno
--where m.empno = e.mgr
;


-- outer join

select *    -- e.ename || ' 의 상사는 ' || m.ename || ' 입니다. '
from emp e, emp m
where e.mgr = m.empno(+)
;


select e.ename, e.empno, e.sal, e.comm, nvl(m.ename, '관리자없음')
from emp e, emp m
where e.mgr = m.empno(+)        -- 정보가 부족한 컬럼 이름 뒤에 + 붙인다.
;


select *
from emp e left outer join emp m  -- 출력하고싶은 방향을 왼쪽.
on e.mgr = m.empno                -- left outer join // right outer join // full outer join .
;



select ename, dname
from emp natural join dept    -- emp 랑 dept에 deptno가 있어서, 
;                              --간단하게 표현할때 natural join 쓴다.



