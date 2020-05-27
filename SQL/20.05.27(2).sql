-- 2020.05.27


-----------------------------------------------------------------

-- view

-----------------------------------------------------------------

-- 논리적인 가상 테이블 : 테이블과 같이 사용 가능, 제약은 존재.
-- 물리적인 테이블 기반으로 만든다 : select 서브쿼리를 이용해서 만든다.

-- create [or replace] view view이름 as 서브쿼리

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 
-- 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.

create view emp_view_deptno30
as
select empno, ename, deptno from emp where deptno=30
;


select * from emp_view_deptno30;

desc user_views;