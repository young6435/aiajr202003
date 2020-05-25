-- 2020.05.21. 목요일.

-- join 문제 풀이.


select * from emp;

select * from dept;   -- 2개가 겹쳐지는게 deptno 다.


32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.

select d.deptno, d.dname        -- dept에 2개 다 있다.
from emp e, dept d
where e.deptno = d.deptno and e.ename = 'SCOTT'
;

33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.

select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno
;

36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.

select * from emp;

select * from dept;

select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno and e.ename like '%A%'        -- dept에 이름없다.
;


37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.

select * from emp;

select * from dept;


select e.ename, e.job, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno and d.loc = 'NEW YORK'
;


38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.

select * from emp;

select * from dept;


select e.ename, e.empno, m.ename 
from emp e, emp m
where e.mgr = m.empno
;

39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.    

select * from emp;


select e.ename, e.empno, m.ename
from emp e , emp m                
where e.mgr = m.empno(+)  
order by e.empno desc
;


select e.ename, e.empno, m.ename       -- ansi 형태 sql 잘 알기.
from emp e left outer join emp m       -- 내가 표현할께 e 라서 left 쓴다.
on e.mgr = m.empno
order by e.empno
;



40. SELF JOIN을 사용하여 지정한 사원과 동일한 부서에서 근무하는 사원이름, 부서번호를 출력하시오. ( SCOTT )    

select * from emp where deptno = 20;

select * from emp;


select e.ename, e.deptno, m.ename
from emp e, emp m
where e.ename = 'SCOTT' and e.deptno = m.deptno and m.ename != 'SCOTT'
;



41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.    

select * from emp e, emp m;

select e.ename, e.hiredate, m.ename, m.hiredate
from emp e, emp m
where m.ename = 'WARD' and e.hiredate > m.hiredate      -- 기준이 m.ename = 'WARD' 이다.
--where e.ename = 'WARD' and e.hiredate < m.hiredate
;


42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.

select * from emp e, emp m;



select e.ename, e.hiredate, m.ename, m.hiredate
from emp e, emp m
where e.mgr = m.empno and e.hiredate < m.hiredate
;


