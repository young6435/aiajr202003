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


------------------------------------------------------------------------------

-- 컬럼의 삭제

-- alter table 테이블이름 drop column 컬럼이름

alter table emp01 drop column sal;

desc emp01;

-------------------------------------------------------------------------------

-- 테이블 객체 삭제                -- 뒤지기 싫으면 고민하고 지워라!
-- drop table 테이블이름;

drop table emp01;
select * from tab;
desc emp01;



-------------------------------------------------------------------------------

-- truncate

select * from emp02;

truncate table emp02;       -- 테이블 안에 모든 로우 제거.      -- 뒤지기 싫으면 고민하고 지워라!
select * from emp02;

-------------------------------------------------------------------------------

-- 테이블 이름 변경

-- rename 현재 테이블 이름 to 새로운 테이블 이름

rename emp02 to test_emp;

select * from tab;

-------------------------------------------------------------------------------

-- 제약조건

desc dept;

insert into dept values(10, 'test', 'seoul');


-- 컬럼의 제약 정의는 컬럼 정의를 하면서 컬럼 옆에 정의
-- 컬럼의 타입을 모두 정의하고, 아래에 제약을 정의하는 방법

--create table emp01(                 -- 실행은 안한다.
    --empno number(4) not null
--)

--create table emp01(
 --   empno number(4),        -- 컬럼을 정의하고,
 --   primary key(empno)      -- 제약사항 정의하고.
--)


---------------------------------------------------------------------

-- not null

-- not null 제약 : 컬럼의 값에 null 값을 허용하지 않는다.
-- 컬럼 레벨에서만 정의가 가능

-- 사원 테이블(EMP02)을 
-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성하되 
-- 이번에는 사원번호와 사원명에 NOT NULL 조건을 지정하도록 합시다.

drop table emp02;

create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

desc emp02;

insert into emp02 values (null, null, 'MANAGER', 10);       -- 에러
insert into emp02 values (1111, null, 'MANAGER', 10);       -- 에러
insert into emp02 values (1111, 'SON', 'MANAGER', 10);      -- 한줄 들어간다.

select * from emp02;

----------------------------------------------------------------------------

-- unique

drop table emp03;

create table emp03(
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

create table emp03(
    empno number(4) unique not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

desc emp03;

insert into emp03 values(1111, 'TEST', 'MANAGER', 10);      -- 행 삽입
insert into emp03 values(1111, 'TEST123', 'MANAGER', 20);   -- 에러
insert into emp03 values(null, 'TEST123', 'MANAGER', 20);   -- 에러

select * from emp03;

-------------------------------------------------------------------

-- unique

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- EMP04 테이블을 생성하되 
-- 사원번호에는 유일키로 사원명은 NOT NULL 제약조건을 설정해 봅시다.

drop table emp04;

create table emp04(
    empno number(4) constraint emp04_empno_uk unique constraint emp04_empno_nn not null,        -- 제약조건 2개다.
    ename varchar2(10)constraint enp04_ename_nn not null,
    job varchar2(10),
    deptno number(2)
);

desc emp04;

insert into emp04 values(1111, 'TEST', 'MANAGER', 10);          -- 행 삽입    
insert into emp04 values(1111, 'TEST123', 'MANAGER', 20);       -- 에러
insert into emp04 values(null, 'TEST123', 'MANAGER', 20);       -- 에러

select * from emp04;

------------------------------------------------------------------------

-- primary key

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 기본 키 제약 조건을 설정해 봅시다.

drop table emp05;

create table emp05(
    empno number(4) constraint emp05_empno_pk primary key,          -- 그냥 primary key 써도 된다.
    ename varchar2(10) constraint emp05_ename_nn not null,
    job varchar2(10),
    deptno number(2)
);

desc emp05;

insert into emp05 values(1111, 'TEST', 'MANAGER', 10);          -- 행 삽입    
insert into emp05 values(1111, 'TEST123', 'MANAGER', 20);       -- 에러
insert into emp05 values(null, 'TEST123', 'MANAGER', 20);       -- 에러


--------------------------------------------------------------------------

-- foreign key

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 기본 키 제약 조건을 설정해 봅시다.
-- deptno 외래키로 제약조건을 설정

drop table emp06;

create table emp06(
    empno number(4) constraint emp06_empno_pk primary key,          
    ename varchar2(10) constraint emp06_ename_nn not null,
    job varchar2(10),
    deptno number(2) CONSTRAINT emp06_deptno_fk REFERENCES dept(deptno)
);

select * from dept;

desc emp06;

insert into emp06 values(1111, 'TEST', 'MANAGER', 10);          -- 행 삽입    
insert into emp06 values(1111, 'TEST123', 'MANAGER', 20);       -- 에러
insert into emp06 values(null, 'TEST123', 'MANAGER', 20);       -- 에러
insert into emp06 values(2222, 'TEST123', 'MANAGER', 50);       -- 에러       -- 10,20,30,40 중에서 써야됨.


---------------------------------------------------------------------------------

-- check 제약조건

-- 사원번호, 사원명, 직급, 부서번호, 직급, 성별, 생일 7개의 칼럼으로 
-- 구성된 테이블을 생성하되 
-- 기본 키 제약 조건, 외래키 제약 조건은 물론 
-- CHECK 제약 조건도 설정해 봅시다.
-- default 제약조건으로 birthday sysdate로 입력되도록 처리.

drop table emp07;

CREATE TABLE EMP07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) DEFAULT 'MANAGER',
    DEPTNO NUMBER(2) CONSTRAINT EMP07_DEPTNO_FK REFERENCES DEPT(DEPTNO),
    GENDER CHAR(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER='M' OR GENDER='F'),
    SAL NUMBER(7,2) CONSTRAINT EMP07_SAL_CK CHECK (SAL BETWEEN 500 AND 5000),
    BIRTHDAY DATE DEFAULT SYSDATE
);

INSERT INTO EMP07 VALUES (1111, 'TEST', NULL, 10, 'F', 600, NULL);
INSERT INTO EMP07 VALUES (1112, 'TEST', NULL, 10, 'M', 600, NULL);

INSERT INTO EMP07 (EMPNO, ENAME, DEPTNO, GENDER, SAL) 
           VALUES (1113, 'TEST', 10, 'F', 1600);

SELECT * FROM EMP07;




