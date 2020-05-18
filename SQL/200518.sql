-- 2020.05.18

select * from emp;

select * from dept;

-- 로그인한 계정이 소유한 테이블 확인.
select * from tab;

-- emp : 사원정보
-- dept : 부서정보
-- bonus : 임시테이블
-- salgrade : 급여 테이블

--테이블의구조 확인 : desc 테이블이름
desc emp;
desc dept;
desc salgrade;      

select * from emp;
select * from dept;

-- 데이터 검색 질의
select ename, sal, deptno, empno    -- 컬럼 이름
from emp    -- 테이블 이름
;

select * from dept;

select deptno   -- 부서넘버     -- 두 줄에 작성해도 가능하다.
from dept;


-- select 의 결과는 새로운 테이블이다.
-- 컬럼의 산술 연산이 가능하다. +, -, *, /, mod(나머지 연산)함수 이용.

select * from emp;                      -- null은 정해지지 않은 data.
select ename, sal, sal + comm           -- null의 연산은 null 이다.
from emp;

select ename, sal, sal+500
from emp;

select ename, sal, sal-100
from emp;

select ename, sal, sal*12
from emp;

select ename, sal, sal/2
from emp;


-- null 값의 확인.
select ename, job, sal, comm, SAL*12, sal*12+Comm       -- 컬럼명 대소문자 상관없다.
from emp;

-- null값 치환 함수 : nvl(컬럼명, 기본값)
-- 기본값은 컬럼의 도메인의 자료형과 같아야 한다.

select ename, job, sal, nvl(comm,0), sal*12 as sal, sal*12+nvl(comm,0) as total     -- as 이름 ==> 별칭 붙인거다.
from emp;

-- 데이터베이스의 문자열 표현 -> 작은 따옴표를 이용.
-- '문자열'
-- 문자열을 붙여서 출력하는 연산 -> ||

select ename || ' is a ' || job as msg
from emp;

select ename, job from emp;     -- 위에처럼 하는게 좋고, 이렇게 하면 힘들다.


-- 출력 컬럼의 중복을 제거하고 하나씩만 출력 : distinct
select deptno from emp;
select distinct deptno from emp;


select deptno, job from emp order by deptno;                -- order by 정렬하는거, 줄세우는거, 기본은 오름차순.
select distinct deptno, job from emp order by deptno;