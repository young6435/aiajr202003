-- 2020.05.26. 화요일.


-----------------------------------------------------------------------

-- DML

-----------------------------------------------------------------------

drop table dept01;


create table dept01                 -- 껍데기 만든다.
as
select * from dept where 1<0
;


desc dept01;

select * from dept01;

----------------------------------------------------------------------

-- 새로운 부서 정보를 입력 : 행단위 입력
-- insert into 테이블이름 (입력하고자 하는 컬럼들) values (데이터들)
-- 입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.


insert into dept01 (deptno, dname, loc) values(10,'MARKETING', 'SEOUL');     --성공 

insert into dept01 VALUES (20,'DESIGN','PUSAN');   -- 성공         --dept가 3개 컬럼인데 그거 3개 다쓸꺼면 생략가능하다.

insert into dept01 (loc, deptno, dname) values('LONDON',30, 'SALES');    -- 성공   -- 입력순서 바꿔도 되는데, 뒤에것도 순서 맞춰야 된다.

insert into dept01 (deptno, dname) values (40,'DEV');    -- 성공   -- loc 가 null 이다.


desc dept01;

select * from dept01;



------------------------------------------------------------------------------------------

drop table dept02;

select * from dept02;


create table dept02(            -- 껍데기 만든다.
    deptno number(2) not null,
    dname varchar2(20) not null,
    loc varchar2(20) default 'SEOUL'
);

insert into dept02 (deptno, dname, loc) values(10,'MARKETING', 'SEOUL');        -- 생성

insert into dept02 (deptno, dname) values (40,'DEV');       -- 생성


-- null 값 입력

insert into dept02 (deptno, dname, loc) values(20,'MARKETING', null); --생성  -- 명시적으로 null 써도 된다.

insert into dept02 (deptno, dname, loc) values(30,'MARKETING', ''); --생성    -- null 값이다. 


-- 오류

insert into dept02 (deptno, dname) values(40, 'DEV', 'PUSAN');      --2/3         -- 개수가 안맞는다.

insert into dept02 (deptno, dname, loc) values(10,'MARKETING');     --3/2         -- 개수가 안맞는다.

insert into dept02 values(40,'MARKETING');      --3/2        -- 개수가 안맞는다.    



select * from dept02;

desc dept02;

insert into dept02 (dname, loc) values('test', 'locTest');      -- 에러    -- deptno가 not null 인데 생략했다.

insert into dept02 (deptno, dname, loc) values(60, 'test', 'locTest');   -- 생성



--------------------------------------------------------------------------------------------








