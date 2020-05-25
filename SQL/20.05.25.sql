--2020.05.25. 월요일.

---------------------------------------------------------
-- DDL
---------------------------------------------------------

-- 테이블 생성
-- create table 테이블의 이름(); <- 괄호 안에 컬럼을 정의
-- (컬럼명1 타입(사이즈), 컬럼명2 타입(사이즈), ...)

-- ddl_test 라는 이름의 테이블을 생성
-- 컬럼1 : no, 숫자타입, 사이즈는 3
-- 컬럼2 : name, 가변 문자열 저장, 사이즈 10
-- 컬럼3 : birth, 날짜 타입, 기본값은 현재 날짜 시간

create table ddl_test (     -- 테이블 만드는 것.
    no number(3),
    name varchar2(10),
    birth date default sysdate
);

desc ddl_test;

select * from tab;

select * from ddl_test;

insert into ddl_test (no, name) values(1, 'scott');     -- 1줄 생성된다.

---------------------------------------------------------------

-- emp 테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
-- EMP01 테이블을 생성해 봅시다.

desc emp;

create table emp01(
    empno number(4),
    ename VARCHAR2(10),
    sal number(7,2)     -- 전체 7자리에 , 소수점 2자리
);

select * from tab;
desc emp01;

-----------------------------------------------------------------

-- 테이블의 복사 : 서브 쿼리 이용 
-- 스키마 복사, 행 복사 가능
-- 제약조건의 복사는 되지 않는다.

create table emp02      
as
SELECT * from emp       -- 복사 원본
;

select * from tab;
desc emp02;
select * from emp02;


-- emp 테이블의 empno 와 ename 컬러만 복사해서 
-- 새로운 테이블 emp03을 생성하자.

create table emp03
as
select empno, ename from emp
;

select * from emp03;
desc emp03;

-- emp 테이블의 10번 부서의 데이터만 복사해서 새로운 테이블
-- emp04 테이블을 생성하자.

create table emp04
as
select * from emp where deptno=10
;

select * from emp04;

-- emp테이블의 스키마 구조만 복사해서 새로운 테이블 emp05를 생성하자.

create table emp05
as
select * from emp where 1<0
;

select * from emp05;

--------------------------------------------------------------------------------

-- 테이블에 컬럼 추가

-- alter table 테이블 이름 add (컬럼정의)

-- emp01 테이블에 직급(job) 컬럼을 추가하자.

desc emp01;

alter table emp01 add(job varchar2(10));

-------------------------------------------------------------------------------

-- 컬럼의 변경

-- alter table modify (컬럼 정의)

-- 직급(job) 컬럼을 최대 30글자까지 저장할 수 있게 변경해 보자.

alter table emp01 modify (job varchar(30) not null);

desc emp01;


