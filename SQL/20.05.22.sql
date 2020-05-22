-- 2020.05.22. 금요일


-- sub query(서브 쿼리)


-- 평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여 
-- 평균 급여보다 더많은 급여를 받는 사원을 검색하는 문장은 다음과 같습니다.

select avg(sal) from emp;



select *
from emp
where sal > 2073.214285714285714285714285714285714286
;


select *
from emp
where sal > (select avg(sal) from emp)  -- 서브쿼리의 결과는 단일행, 단일열이 되어야 한다.
;

----------------------------------------------------


select deptno from emp where ename ='SCOTT';


select *
from emp
where deptno = 20
;


select *
from emp
where deptno = (select deptno from emp where ename ='SCOTT')
;

-- 서브쿼리 작성할때 2개를 따로 만들어서 합치는게 좋다.


-----------------------------------------------------

-- 다중행 서브 쿼리

-- 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 
-- 동일한 부서에서 근무하는 사원이기에 
-- 서브 쿼리의 결과 중에서 하나라도 일치하면 참인 결과를 구하는 
-- IN 연산자와 함께 사용되어야 합니다.

select *
from emp
where deptno in (10,20)
;

select distinct deptno from emp where sal >= 3000;


select *
from emp
where deptno in (select distinct deptno from emp where sal >= 3000)
;

-----------------------------------------------------

-- ALL 연산자

select sal from emp where deptno=30;        -- 최고가 2850

select max(sal) from emp where deptno=30;

select ename, sal
from emp
where sal > (select max(sal) from emp where deptno=30)
;


select ename, sal
from emp
where sal > all(select sal from emp where deptno=30)
;

--------------------------------------------------------

-- any 연산자

-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 
-- 많은 급여를 받는 사원의 이름, 급여를 출력하는 예제

select min(sal) from emp where deptno=30;

select ename, sal from emp where sal > 950;

select ename, sal from emp where sal > (select min(sal) from emp where deptno=30);      -- 이렇게 많이 쓴다.

select ename, sal from emp where sal > any(select sal from emp where deptno=30);


--------------------------------------------------------

-- rownum : 입력순서의번호

select rownum, ename
from emp
;

-------------------------------------------------------

-- 스칼라 부속질의 : 컬럼을 표현
-- 마당서점의 고객별 판매액을 보이시오
-- (결과는 고객이름과 고객별 판매액을 출력).

select name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by name
;


select o.custid, name, sum(saleprice)           -- 이게 낫다.
from orders o, customer c
where o.custid = c.custid
group by o.custid, name
;


select custid, 
( select name from customer c where o.custid=c.custid)
as custom_name, sum(saleprice)
from orders o
group by custid
;




